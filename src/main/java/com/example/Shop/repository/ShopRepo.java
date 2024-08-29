package com.example.Shop.repository;

import com.example.Shop.model.Product;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ShopRepo extends MongoRepository<Product,Long> {
    List<Product> findByPriceGreaterThan(double price);
    List<Product> findByName(String name);
    List<Product> findByPriceGreaterThanAndName(double price, String name);
    List<Product> findAllByProductIdIn(List<Long> productIds);
}