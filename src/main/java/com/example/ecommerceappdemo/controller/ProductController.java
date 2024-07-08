package com.example.ecommerceappdemo.controller;

import com.example.ecommerceappdemo.model.Product;
import com.example.ecommerceappdemo.model.projection.ProductWithIdAndName;
import com.example.ecommerceappdemo.service.IProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController{
    IProductService iProductService;
    public ProductController(IProductService iProductService){
        this.iProductService = iProductService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(name = "id") Long id){
        Product product = iProductService.getProductById(id);
        return product;
    }

    @GetMapping()
    public List<ProductWithIdAndName> getAllProduct(){
        List<ProductWithIdAndName> productList = iProductService.getAllProduct();
        return productList;
    }

    @PostMapping()
    public Product addNewProduct(@RequestBody Product product){
        return iProductService.addNewProduct(product);
    }

    @DeleteMapping("/{id}")
    public Product deleteAProduct(@RequestParam(name = "id") int id){
        return null;
    }
}
