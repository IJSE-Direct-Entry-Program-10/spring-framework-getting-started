package lk.ijse.dep10.spring.winner.api;

import lk.ijse.dep10.spring.winner.dto.WinnerDTO;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;

@Controller
@RequestMapping("/candidates/current")
public class CandidateController {

    @Autowired
    private BasicDataSource dbcp;

    @GetMapping
    public String getCurrentCandidate(Model model){
        try (Connection connection = dbcp.getConnection()) {
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT value FROM MetaData WHERE `key`='CandidateID'");
            ResultSet rst2 = stm
                    .executeQuery("SELECT value FROM MetaData WHERE `key`='CandidateSelectedDate'");
            WinnerDTO candidate = null;
            if (rst.next() && rst2.next()){
                int id = rst.getInt("value");
                Date selectedDate = rst.getDate("value");
                rst = stm.executeQuery("SELECT * FROM Student WHERE id=" + id);
                if (rst.next()){
                    String name = rst.getString("name");
                    String nickName = rst.getString("nick_name");
                    String pictureUrl = rst.getString("picture_url");
                    candidate = new WinnerDTO(id, name, nickName, pictureUrl,
                            selectedDate, null);
                }
            }
            model.addAttribute("candidate", candidate);
            return "current-candidate";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
