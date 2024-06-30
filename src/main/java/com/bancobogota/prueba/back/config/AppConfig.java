package com.bancobogota.prueba.back.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bancobogota.prueba.back.service.ClientServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public ClientServiceImpl beanClientServiceImpl(){
        return new ClientServiceImpl();
    }
}