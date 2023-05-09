package lk.ijse.dep10.spring.web;

import lk.ijse.dep10.spring.web.api.MyController1;
import lk.ijse.dep10.spring.web.api.MyController2;
import lk.ijse.dep10.spring.web.api.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class WebAppConfig implements WebMvcConfigurer {

    public WebAppConfig() {
        System.out.println("WebAppConfig()");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor());
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver jspResolver = new InternalResourceViewResolver();
        jspResolver.setPrefix("WEB-INF/page/");
        jspResolver.setSuffix(".jsp");
        registry.viewResolver(jspResolver);
    }

    @Bean
    public MyController1 myController1(){
        System.out.println("Who the heck invoked me?");
        return new MyController1();
    }

    @Bean
    public MyController2 myController2(){
        System.out.println("Damn! I have been invoked again");
        return new MyController2();
    }
}
