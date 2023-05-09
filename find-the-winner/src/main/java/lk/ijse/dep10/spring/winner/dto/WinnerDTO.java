package lk.ijse.dep10.spring.winner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WinnerDTO {
    private int id;
    private String name;
    private String nickName;
    private String pictureUrl;
    private Date selectedDate;
    private Date performedDate;
}
