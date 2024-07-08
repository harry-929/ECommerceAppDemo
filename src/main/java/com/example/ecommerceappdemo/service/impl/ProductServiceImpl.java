package com.example.ecommerceappdemo.service.impl;

import com.example.ecommerceappdemo.model.Category;
import com.example.ecommerceappdemo.model.Product;
import com.example.ecommerceappdemo.model.projection.ProductWithIdAndName;
import com.example.ecommerceappdemo.repository.ICategoryRepository;
import com.example.ecommerceappdemo.repository.IProductRepository;
import com.example.ecommerceappdemo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<ProductWithIdAndName> getAllProduct() {
        List<ProductWithIdAndName> productList = iProductRepository.findAllByIdAndName();
        return productList;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = iProductRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new RuntimeException();
        }
        Product product = optionalProduct.get();
        return product;
    }

    @Override
    public Product addNewProduct(Product product) {
        Optional<Category> optionalCategory = iCategoryRepository.findCategoryByName(product.getCategory().getName());
        if (optionalCategory.isEmpty()) {
            product.setCategory(iCategoryRepository.save(product.getCategory()));
        }else {
            product.setCategory(optionalCategory.get());
        }
        Optional<Category> optionalCategory1 = iCategoryRepository.findCategoryByName(product.getCategory().getName());
        Category category = optionalCategory1.get();
        List<Product> productList = category.getProducts();
        if(productList != null){
            for(Product product1 : productList){
                System.out.println(product1.getName());
            }
        }
        return iProductRepository.save(product);
    }

    @Override
    public Product deleteAProduct(int id) {
        return null;
    }
}
