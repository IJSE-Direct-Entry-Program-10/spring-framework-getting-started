package lk.ijse.dep10.mapping;

import lk.ijse.dep10.mapping.api.CustomerController;
import lk.ijse.dep10.mapping.api.ItemController;
import lk.ijse.dep10.mapping.api.OrderController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebAppConfig {

//    @Bean
//    public CustomerController customerController(){
//        return new CustomerController();
//    }
//
//    @Bean
//    public ItemController itemController(){
//        return new ItemController();
//    }
//
//    @Bean
//    public OrderController orderController(){
//        return new OrderController();
//    }
}
