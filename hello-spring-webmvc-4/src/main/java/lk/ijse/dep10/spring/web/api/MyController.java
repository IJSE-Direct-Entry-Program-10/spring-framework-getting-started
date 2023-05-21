package lk.ijse.dep10.spring.web.api;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class MyController {

    public MyController() {
        System.out.println("MyController()");
    }

    @GetMapping
    public String getAllCustomers(){
        return "";
    }

    @PostMapping
    public String saveCustomer(){
        return "";
    }
}
