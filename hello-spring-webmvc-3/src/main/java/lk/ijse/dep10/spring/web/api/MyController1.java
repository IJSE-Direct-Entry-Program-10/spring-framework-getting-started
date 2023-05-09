package lk.ijse.dep10.spring.web.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.HashMap;
import java.util.Map;

@Controller /* @Component */
@RequestMapping("/hello")
public class MyController1 {

    public MyController1() {
        System.out.println("MyController1");
    }

    @GetMapping
    public ModelAndView doSomething(){
        System.out.println("MyController1: doSomething()");
        Map<String, Object> model = new HashMap<>();
        model.put("something", "ijse");
        return new ModelAndView("something", model);
    }
}
