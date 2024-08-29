
package com.example.Shop.service.Implements;

import com.example.Shop.model.User;
import com.example.Shop.repository.UserRepo;
import com.example.Shop.service.Interface.sequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductUserService implements com.example.Shop.service.Interface.ProductUserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private sequenceGeneratorService sg;
    @Override
    public void createProductUser(User user) {
        user.setUserId(sg.generateSequence(user.SEQUENCE_NAME));
        userRepo.save(user);
    }
    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }
    @Override
    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }
    @Override
    public void updateUser(User updatedUser, long id) {
        userRepo.findById(id).map(productUser -> {
            productUser.setUserId(updatedUser.getUserId());
            productUser.setName(updatedUser.getName());
            productUser.setEmail(updatedUser.getEmail());
            productUser.setPassword(updatedUser.getPassword());
            productUser.setAddress(updatedUser.getAddress());
            productUser.setPhoneNumber(updatedUser.getPhoneNumber());
            return userRepo.save(productUser);
        }).orElseThrow(() -> new RuntimeException("ProductUser not found with id " + id));
    }
}
