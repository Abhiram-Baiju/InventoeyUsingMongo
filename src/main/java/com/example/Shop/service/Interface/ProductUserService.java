package com.example.Shop.service.Interface;

import com.example.Shop.model.User;

import java.util.List;

public interface ProductUserService {
    void createProductUser(User user);
    void deleteUser(long id);
    List<User>getAllUser();
    void updateUser(User user, long id);
}