package lk.ijse.dep10.spring.winner.api;

import lk.ijse.dep10.spring.winner.dto.WinnerDTO;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

@RequestMapping("/winners")
@Controller
public class WinnerController {

    @Autowired
    private BasicDataSource dbcp;

    @GetMapping
    public String getAllWinners(Model model){
        try (Connection connection = dbcp.getConnection()) {
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT S.name, S.picture_url, W.selected_date, W.performed_date\n" +
                    "FROM Winner W INNER JOIN Student S on W.student_id = S.id");
            ArrayList<WinnerDTO> winnerList = new ArrayList<>();
            while (rst.next()){
                String name = rst.getString("name");
                String pictureUrl = rst.getString("picture_url");
                Date selectedDate = rst.getDate("selected_date");
                Date performedDate = rst.getDate("performed_date");
                winnerList.add(new WinnerDTO(0, name, null, pictureUrl, selectedDate, performedDate));
            }
            model.addAttribute("winners", winnerList);
            return "list-previous-winners";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /* id=1&password=fdjasfj */
    @PostMapping
    public String saveWinner(String password, @RequestParam("id") int studentId, @RequestParam("selected-date") String selectedDate) {
        try (Connection connection = dbcp.getConnection()) {
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT value FROM MetaData WHERE `key`='MasterPassword'");
            if (rst.next()) {
                String shaPassword = rst.getString("value");
                if (DigestUtils.sha256Hex(password).equals(shaPassword)) {

                    try {
                        connection.setAutoCommit(false);

                        PreparedStatement stmInsertWinner = connection.prepareStatement("INSERT INTO Winner (student_id, selected_date, performed_date)  VALUES (?, ?, ?)");
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
                    } finally {
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
