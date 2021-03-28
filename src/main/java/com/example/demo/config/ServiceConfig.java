package com.example.demo.config;

import com.example.demo.service.GrowBoxService;
import com.example.demo.service.GrowBoxServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    @Autowired
    public GrowBoxService growBoxService(){
        return new GrowBoxServiceImpl();
    }
}
