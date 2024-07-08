package com.example.ecommerceappdemo.service;


import com.example.ecommerceappdemo.model.Product;
import com.example.ecommerceappdemo.model.projection.ProductWithIdAndName;

import java.util.List;

public interface IProductService {
    List<ProductWithIdAndName> getAllProduct();
    Product getProductById(Long id);
    Product addNewProduct(Product product);

    Product deleteAProduct(int id);
}
