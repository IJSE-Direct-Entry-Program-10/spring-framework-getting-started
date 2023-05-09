package lk.ijse.dep10.spring.web;

import lk.ijse.dep10.spring.web.api.HelloSpringWeb;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
public class WebAppConfig {

    @Bean
    public HelloSpringWeb helloSpringWeb(){
        return new HelloSpringWeb();
    }
}
