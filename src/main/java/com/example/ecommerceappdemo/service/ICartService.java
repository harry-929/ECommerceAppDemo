package com.example.ecommerceappdemo.service;

import com.example.ecommerceappdemo.dto.CartDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICartService {

    public List<CartDTO> getAllCarts() throws JsonProcessingException;

    //public CartDTO addCart(CartDTO cart);
}
