package com.example.ecommerceappdemo.service.impl;

import com.example.ecommerceappdemo.dto.CartDTO;
import com.example.ecommerceappdemo.service.FakeStoreExceptionHandler;
import com.example.ecommerceappdemo.service.ICartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {

    private static final String GET_CART_API_ENDPOINT = "https://fakestoreapi.com/carts";

    //As the rest-template helps to call and get the http endpoint will use that
    @Autowired(required = true)
    RestTemplate restTemplate;
    @Override
    public List<CartDTO> getAllCarts() throws JsonProcessingException {
        List<CartDTO> carts_4 = new ArrayList<>();

        try{
            //ResponseEntity<String> responseString = restTemplate.getForEntity(GET_CART_API_ENDPOINT, String.class);

            ResponseEntity<String> responseString = restTemplate.exchange(GET_CART_API_ENDPOINT,
                    HttpMethod.GET, null, String.class);
            if(responseString.getStatusCode().is2xxSuccessful()){
                carts_4 = new ObjectMapper().readValue(responseString.getBody(), new TypeReference<List<CartDTO>>() {});
            }else{
                StringBuilder errorMessage = new StringBuilder();
                errorMessage.append("Error getting all the carts from fake store api at : ");
                errorMessage.append(GET_CART_API_ENDPOINT);
                errorMessage.append(" responded with ");
                errorMessage.append(responseString.getStatusCode());
                errorMessage.append("Error : ");
                errorMessage.append("There is a downtime, Please try after sometime");
                throw new RuntimeException(errorMessage.toString());
            }

        }catch(Exception ex){
            throw new FakeStoreExceptionHandler(null, HttpStatus.INTERNAL_SERVER_ERROR, null);
        }

        return carts_4;
    }

    @Override
    public CartDTO getSingleCart(int cId) throws JsonProcessingException {
        CartDTO singleCart = new CartDTO();
        String endPoint = GET_CART_API_ENDPOINT + "/" + cId;
        try{
            //ResponseEntity<String> responseString = restTemplate.getForEntity(GET_CART_API_ENDPOINT, String.class);

            ResponseEntity<String> responseString = restTemplate.exchange(endPoint,
                    HttpMethod.GET, null, String.class);
            if(responseString.getStatusCode().is2xxSuccessful()){
                singleCart = new ObjectMapper().readValue(responseString.getBody(),
                        new TypeReference<CartDTO>() {});
            }else{
                StringBuilder errorMessage = new StringBuilder();
                errorMessage.append("Error getting all the carts from fake store api at : ");
                errorMessage.append(GET_CART_API_ENDPOINT);
                errorMessage.append(" responded with ");
                errorMessage.append(responseString.getStatusCode());
                errorMessage.append("Error : ");
                errorMessage.append("There is a downtime, Please try after sometime");
                throw new RuntimeException(errorMessage.toString());
            }

        }catch(Exception ex){
            throw new FakeStoreExceptionHandler(null, HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
        return singleCart;
    }

    @Override
    public List<CartDTO> getUserCart(int userId) throws JsonProcessingException {
        List<CartDTO> userCart = new ArrayList<>();
        String endPoint = GET_CART_API_ENDPOINT + "/user/" + userId;
        //send the request to above endpoints
        try {
            ResponseEntity<String> responseString = restTemplate.exchange(endPoint,
                    HttpMethod.GET, null, String.class);

            if(responseString.getStatusCode().is2xxSuccessful()){
                userCart = new ObjectMapper().readValue(responseString.getBody(),
                        new TypeReference<List<CartDTO>>() {});
            }
        }catch (Exception ex){
            throw new FakeStoreExceptionHandler(null, HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
        return userCart;
    }

    @Override
    public CartDTO addNewCart(CartDTO cart) {
        CartDTO response = restTemplate.postForObject(GET_CART_API_ENDPOINT, cart, CartDTO.class);
        return response;
    }

    @Override
    public CartDTO updateCart(int cId) {
        return null;
    }

    @Override
    public CartDTO deleteCart(int cId) {
        return null;
    }

}
