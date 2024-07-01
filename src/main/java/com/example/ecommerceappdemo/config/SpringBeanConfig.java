package com.example.ecommerceappdemo.config;

import com.example.ecommerceappdemo.service.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeanConfig {

    @Bean
    public CustomerService customerService(){
        return new CustomerService();
    }
}
