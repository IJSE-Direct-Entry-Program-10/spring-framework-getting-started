package lk.ijse.dep10.mapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private String id;
    private String name;
    private String address;
    private List<String> contact = new ArrayList<>();
}
