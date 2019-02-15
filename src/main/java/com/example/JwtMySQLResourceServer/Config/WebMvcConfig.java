package com.example.JwtMySQLResourceServer.Config;

import com.example.JwtMySQLResourceServer.User.CurrentUserResolver;
import com.example.JwtMySQLResourceServer.User.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    private final CurrentUserService currentUserService;

    @Autowired
    public WebMvcConfig(CurrentUserService currentUserService) {
        this.currentUserService = currentUserService;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new CurrentUserResolver(currentUserService));
    }
}
