package com.web_project.school.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/login").setViewName("login");
//        registry.addViewController("/register").setViewName("register");
//        registry.addViewController("/about").setViewName("about");
//        registry.addViewController("/contact").setViewName("contact");
//        registry.addViewController("/admin").setViewName("admin");
//        registry.addViewController("/admin/dashboard").setViewName("admin/dashboard");
    }
}
