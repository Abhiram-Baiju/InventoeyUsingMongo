package com.example.Shop.repository;

import com.example.Shop.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,Long> {
}