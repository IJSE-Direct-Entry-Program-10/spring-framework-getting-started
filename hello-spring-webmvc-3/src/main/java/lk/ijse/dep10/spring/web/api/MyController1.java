package lk.ijse.dep10.spring.web.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller /* @Component */
@RequestMapping("/hello")
public class MyController1 {

    public MyController1() {
        System.out.println("MyController1");
    }

    @GetMapping
    public String doSomething(Model model){
        System.out.println("MyController1: doSomething()");
        model.addAttribute("something", "ijse");
        return "something";
    }
}
