package com.example.ecommerceappdemo.repository;

import com.example.ecommerceappdemo.model.Product;
import com.example.ecommerceappdemo.model.projection.ProductWithIdAndName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Override
    List<Product> findAll();

    @Query(value = "select * from products", nativeQuery = true)
    List<Product> findAllProducts();

    @Override
    Optional<Product> findById(@Param("id") Long aLong);

    List<Product> findByNameContaining(String word);
    @Query(value = "select id, name, description from products", nativeQuery = true)
    List<ProductWithIdAndName> findAllByIdAndName();
}
