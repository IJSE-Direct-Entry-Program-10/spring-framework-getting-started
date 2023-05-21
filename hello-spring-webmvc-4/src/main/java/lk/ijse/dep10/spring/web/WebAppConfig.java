package lk.ijse.dep10.spring.web;

import lk.ijse.dep10.spring.web.api.MyController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class WebAppConfig {

    public WebAppConfig() {
        System.out.println("WebAppConfig()");
    }

    public String doSomething(){
        System.out.println("doSomething()");
        return "Ijse";
    }

    @Bean
    public MyController doSomethingImplicitly(){
        System.out.println("doSomethingImplicitly");
        return new MyController();
    }
}
