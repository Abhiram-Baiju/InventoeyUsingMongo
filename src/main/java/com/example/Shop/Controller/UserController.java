package com.example.Shop.Controller;

import com.example.Shop.model.User;
import com.example.Shop.service.Interface.ProductUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class UserController {
    @Autowired
    private ProductUserService productUserService;

    @PostMapping(path ="/User")
    public void createProductUser(@Valid @RequestBody User user){
        productUserService. createProductUser(user);
    }

    @GetMapping(path ="/User")
    public List<User>getAllUser(){
        return productUserService.getAllUser();
    }

    @DeleteMapping(path = "/User/{productId}")
    public void deleteUser(@PathVariable long productId){
        productUserService.deleteUser(productId);
    }

    @PutMapping(path = "/User/{productId}")
    public void updateUser(@RequestBody User user, @PathVariable long productId){
        productUserService.updateUser(user,productId);}
}