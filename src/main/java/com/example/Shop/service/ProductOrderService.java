//package com.example.Shop.service;
//
//import com.example.Shop.model.ProductOrder;
//import com.example.Shop.repository.OrderRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ProductOrderService {
//    @Autowired
//    private OrderRepo orderRepo;
//
//    public void CreateProductOrder(ProductOrder productOrder) {
//        orderRepo.save(productOrder);
//    }
//
//    public List<ProductOrder> getAllorder() {
//        return orderRepo.findAll();
//    }
//
//    public void deleteOrder(String id) {
//        orderRepo.deleteById(id);
//    }
//
//
//    public void updateOrder(ProductOrder updatedProductOrder, String id) {
//        orderRepo.findById(id).map(productOrder -> {
//            productOrder.setuserName(updatedProductOrder.getUserName());
//            productOrder.setOrderDate(updatedProductOrder.getOrderDate());
//            productOrder.setStatus(updatedProductOrder.getStatus());
//            productOrder.setTotalAmount(updatedProductOrder.getTotalAmount());
//            return orderRepo.save(productOrder);
//        }).orElseThrow(() -> new RuntimeException("Product not found with id " + id));
//    }
//
//
//    public List<ProductOrder> getOrderByUserName(String userName) {
//        return orderRepo.findByUserName(userName);
//    }
//}
