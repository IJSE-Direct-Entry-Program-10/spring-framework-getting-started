package lk.ijse.dep10.spring.web.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController /* @Controller + @ResponseBody */
@RequestMapping("/hello2")
public class MyController2 {

    public MyController2() {
        System.out.println("MyController2");
    }

    @GetMapping
    public String doSomething(){
        System.out.println("MyController2: doSomething()");
        return "<h1>I am from My Controller 2</h1>";
    }
}
