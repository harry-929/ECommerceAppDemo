package com.example.ecommerceappdemo.service;

import com.example.ecommerceappdemo.dto.CartDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICartService {

    public List<CartDTO> getAllCarts() throws JsonProcessingException;
    //return cart for the single user
    public CartDTO getSingleCart(int cId) throws JsonProcessingException;
    public List<CartDTO> getUserCart(int userId) throws JsonProcessingException;
    //add new cart in the list of the carts
    public CartDTO addNewCart(CartDTO cart);
    //should update the cart for the specific user
    public CartDTO updateCart(int cId);
    //remove the cart
    public CartDTO deleteCart(int cId);
}
