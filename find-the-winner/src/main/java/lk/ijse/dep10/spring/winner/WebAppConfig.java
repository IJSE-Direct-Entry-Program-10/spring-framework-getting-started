package lk.ijse.dep10.spring.winner;

import lk.ijse.dep10.spring.winner.api.CandidateController;
import lk.ijse.dep10.spring.winner.api.WinnerController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver jspResolver = new InternalResourceViewResolver();
        jspResolver.setPrefix("/WEB-INF/page/");
        jspResolver.setSuffix(".jsp");
        registry.viewResolver(jspResolver);
    }

    @Bean
    public CandidateController candidateController(){
        return new CandidateController();
    }

    @Bean
    public WinnerController winnerController(){
        return new WinnerController();
    }
}
