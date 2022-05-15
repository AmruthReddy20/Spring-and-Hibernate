package com.springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.springsecurity.demo")
public class DemoAppConfig {
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver internalviewResolver=new InternalResourceViewResolver();
        internalviewResolver.setPrefix("/WEB-INF/view/");
        internalviewResolver.setSuffix(".jsp");
        return internalviewResolver;

    }

}
