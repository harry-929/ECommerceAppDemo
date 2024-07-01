package com.example.ecommerceappdemo.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.net.http.HttpClient;

public class CustomerService {

    HttpClient httpClient;

    public CustomerService(){
        System.out.println("I am being instantiated at the time of startup");
    }
}
