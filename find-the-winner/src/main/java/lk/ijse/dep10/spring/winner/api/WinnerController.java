package lk.ijse.dep10.spring.winner.api;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.time.LocalDate;

@RequestMapping("/winners")
@Controller
public class WinnerController {

    @Autowired
    private BasicDataSource dbcp;

    /* id=1&password=fdjasfj */
    @PostMapping
    public String saveWinner(String password,
                             @RequestParam("id") int studentId,
                             @RequestParam("selected-date") String selectedDate){
        try (Connection connection = dbcp.getConnection()) {
            Statement stm = connection.createStatement();
            ResultSet rst = stm
                    .executeQuery("SELECT value FROM MetaData WHERE `key`='MasterPassword'");
            if (rst.next()){
                String shaPassword = rst.getString("value");
                if (DigestUtils.sha256Hex(password).equals(shaPassword)){

                    try {
                        connection.setAutoCommit(false);

                        PreparedStatement stmInsertWinner = connection
                                .prepareStatement("INSERT INTO Winner (student_id, selected_date, performed_date)  VALUES (?, ?, ?)");
                        stmInsertWinner.setInt(1, studentId);
                        stmInsertWinner.setDate(2, Date.valueOf(selectedDate));
                        stmInsertWinner.setDate(3, Date.valueOf(LocalDate.now()));
                        stmInsertWinner.executeUpdate();

                        Statement stmClearMeta = connection.createStatement();
                        stmClearMeta.executeUpdate("UPDATE MetaData SET value=NULL WHERE `key`='CandidateID'");
                        stmClearMeta.executeUpdate("UPDATE MetaData SET value=NULL WHERE `key`='CandidateSelectedDate'");

                        connection.commit();
                    } catch (SQLException e) {
                        connection.rollback();
                        e.printStackTrace();
                    }finally {
                        connection.setAutoCommit(true);
                    }
                }
            }
            return "redirect:/candidates/current";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
