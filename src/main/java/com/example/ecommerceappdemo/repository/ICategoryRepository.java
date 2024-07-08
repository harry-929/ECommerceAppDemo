package com.example.ecommerceappdemo.repository;

import com.example.ecommerceappdemo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<Category, Long> {

    @Override
    Optional<Category> findById(Long aLong);

    @Query(value = "select * from categories c where c.name = :name", nativeQuery = true)
    Optional<Category> findCategoryByName(@Param("name") String word);

    @Override
    List<Category> findAll();
}
