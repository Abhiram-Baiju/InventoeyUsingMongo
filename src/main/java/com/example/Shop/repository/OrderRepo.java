package com.example.Shop.repository;

import com.example.Shop.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepo extends MongoRepository<Order,Long> {
    List<Order> findByUserId(long userId);
}