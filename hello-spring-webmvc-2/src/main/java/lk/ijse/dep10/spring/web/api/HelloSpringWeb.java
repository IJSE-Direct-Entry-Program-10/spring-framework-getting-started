package lk.ijse.dep10.spring.web.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloSpringWeb {

    @PostMapping
    public void hello(){
        System.out.println("Hello");
    }

    @GetMapping
    public String deleteSomething(){
        return "Let's delete something";
    }
}
