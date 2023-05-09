package lk.ijse.dep10.spring.winner;

import lk.ijse.dep10.spring.winner.api.CandidateController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver jspResolver = new InternalResourceViewResolver();
        jspResolver.setPrefix("WEB-INF/page/");
        jspResolver.setPrefix(".jsp");
        registry.viewResolver(jspResolver);
    }

    @Bean
    public CandidateController candidateController(){
        return new CandidateController();
    }
}
