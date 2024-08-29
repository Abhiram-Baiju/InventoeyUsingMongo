//package com.example.Shop.service;
//
//import com.example.Shop.model.ProductUser;
//import com.example.Shop.repository.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ProductUserService {
//    @Autowired
//    private UserRepo userRepo;
//
//    public void createProductUser(ProductUser productUser) {
//        userRepo.save(productUser);
//    }
//
//    public List<ProductUser> getAlluser() {
//        return userRepo.findAll();
//    }
//
//    public void deleteUser(String id) {
//        userRepo.deleteById(id);
//    }
//
//    public void updateUser(ProductUser updatedProductUser, String id) {
//        userRepo.findById(id).map(productUser -> {
//            productUser.setId(updatedProductUser.getId());
//            productUser.setName(updatedProductUser.getName());
//            productUser.setEmail(updatedProductUser.getEmail());
//            productUser.setPassword(updatedProductUser.getPassword());
//            productUser.setAddress(updatedProductUser.getAddress());
//            productUser.setPhoneNumber(updatedProductUser.getPhoneNumber());
//            return userRepo.save(productUser);
//        }).orElseThrow(() -> new RuntimeException("ProductUser not found with id " + id));
//    }
//}
