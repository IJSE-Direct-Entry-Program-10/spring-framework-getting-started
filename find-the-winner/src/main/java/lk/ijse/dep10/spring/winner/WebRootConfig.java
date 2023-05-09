package lk.ijse.dep10.spring.winner;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebRootConfig {

    @Bean
    public BasicDataSource basicDataSource(){
        BasicDataSource dbcp = new BasicDataSource();
        dbcp.setUrl("jdbc:mysql://localhost:3306/dep10_winner");
        dbcp.setUsername("root");
        dbcp.setPassword("mysql");
        dbcp.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dbcp.setInitialSize(10);
        dbcp.setMaxTotal(20);
        return dbcp;
    }
}
