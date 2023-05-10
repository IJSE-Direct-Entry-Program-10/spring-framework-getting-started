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

import java.sql.*;
import java.time.LocalDate;

@Controller
@RequestMapping("/candidates/current")
public class CandidateController {

    @Autowired
    private BasicDataSource dbcp;

    @GetMapping
    public String getCurrentCandidate(Model model) {
        try (Connection connection = dbcp.getConnection()) {
            Statement stm = connection.createStatement();
            Statement stm2 = connection.createStatement();
            Statement stm3 = connection.createStatement();

            ResultSet rst = stm.executeQuery("SELECT value FROM MetaData WHERE `key`='CandidateID'");
            ResultSet rst2 = stm2.executeQuery("SELECT value FROM MetaData WHERE `key`='CandidateSelectedDate'");

            WinnerDTO candidate = null;

            if (rst.next() && rst2.next()) {
                int id = rst.getInt("value");
                Date selectedDate = rst2.getDate("value");

                ResultSet rst3 = stm3.executeQuery("SELECT * FROM Student WHERE id=" + id);
                if (rst3.next() && selectedDate != null) {
                    String name = rst3.getString("name");
                    String nickName = rst3.getString("nick_name");
                    String pictureUrl = rst3.getString("picture_url");
                    candidate = new WinnerDTO(id, name, nickName, pictureUrl, selectedDate, null);
                }
            }
            model.addAttribute("candidate", candidate);
            return "current-candidate";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public String pickNewCandidate(String password){
        try (Connection connection = dbcp.getConnection()) {
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT value FROM MetaData WHERE `key`='MasterPassword'");

            if (rst.next()){
                String shaPassword = rst.getString("value");

                if (shaPassword.equals(DigestUtils.sha256Hex(password))){

                    Statement stmRandom = connection.createStatement();
                    ResultSet rst2 = stmRandom.executeQuery("SELECT * FROM Student LEFT OUTER JOIN Winner W ON Student.id = W.student_id\n" +
                            "WHERE W.student_id IS NULL ORDER BY RAND() LIMIT 1");

                    if (rst2.next()){
                        int newCandidateId = rst2.getInt("id");

                        try {
                            connection.setAutoCommit(false);
                            PreparedStatement stmSetCandidate = connection
                                    .prepareStatement("UPDATE MetaData SET value=? WHERE `key`='CandidateID'");
                            PreparedStatement stmSetDate = connection
                                    .prepareStatement("UPDATE MetaData SET value=? WHERE `key`='CandidateSelectedDate'");
                            stmSetCandidate.setString(1, newCandidateId + "");
                            stmSetDate.setString(1, LocalDate.now().toString());
                            stmSetCandidate.executeUpdate();
                            stmSetDate.executeUpdate();

                            connection.commit();
                        }catch (SQLException e){
                            connection.rollback();
                            e.printStackTrace();
                        }finally {
                            connection.setAutoCommit(true);
                        }
                    }
                }
            }
            return "redirect:/candidates/current";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
