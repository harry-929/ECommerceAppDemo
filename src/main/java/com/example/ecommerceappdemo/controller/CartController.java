package com.example.ecommerceappdemo.controller;

import com.example.ecommerceappdemo.dto.CartDTO;
import com.example.ecommerceappdemo.service.ICartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ICartService cartService;
    Logger logger = LoggerFactory.getLogger(CartController.class);

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CartDTO>> loadAllCarts() throws JsonProcessingException{
        logger.info("Started calling the cart services");
        ResponseEntity<List<CartDTO>> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        List<CartDTO> response = cartService.getAllCarts();
        if(!CollectionUtils.isEmpty(response)){
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        }
        return responseEntity;
    }

    /* Below function loads the single cart from the list of carts*/
    @GetMapping("/{id}")
    public ResponseEntity<CartDTO> loadSingleCart(@PathVariable(name = "id") int id)
            throws JsonProcessingException {
        ResponseEntity<CartDTO> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        CartDTO response = cartService.getSingleCart(id);

        if (!response.isEmpty()) {
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        }
        return responseEntity;
    }

    /*Below function will load the List of carts for a specific user*/
    @GetMapping("/user/{id}")
    public ResponseEntity<List<CartDTO>> loadUserCart(@PathVariable(name = "id") int id)
            throws JsonProcessingException{
        ResponseEntity<List<CartDTO>> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        List<CartDTO> response = cartService.getUserCart(id);

        if(!CollectionUtils.isEmpty(response)){
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        }
        return responseEntity;
    }
}

