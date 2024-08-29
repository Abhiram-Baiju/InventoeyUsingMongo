//package com.example.Shop.service;
//
//import com.example.Shop.model.Product;
//import com.example.Shop.repository.ShopRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.w3c.dom.css.Counter;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;
//
//@Service
//public class ProductService {
//    @Autowired
//    private ShopRepo shopRepo;
//
//    public void createProduct(Product product) {
//         shopRepo.save(product);
//    }
//
//    public List<Product> getAllProduct() {
//        return shopRepo.findAll();
//    }
//
//    public void deleteProduct(String id) {
//        shopRepo.deleteById(id);
//    }
//
//    public void updateProduct(Product updatedProduct, String id) {
//        shopRepo.findById(id).map(product -> {
//            product.setId(updatedProduct.getId());
//            product.setName(updatedProduct.getName());
//            product.setPrice(updatedProduct.getPrice());
//            product.setCategoryid(updatedProduct.getCategoryid());
//            product.setQuantity(updatedProduct.getQuantity());
//            return shopRepo.save(product);
//        }).orElseThrow(()->new RuntimeException("Product not found"+id));
//    }
//
//    public List<Product> getProductByPriceGreaterThan(double price) {
//
//        return shopRepo.findByPriceGreaterThan(price);
//    }
//
//    public List<Product> getProductByname(String name) {
//        return shopRepo.findByName(name);
//    }
//}
//
