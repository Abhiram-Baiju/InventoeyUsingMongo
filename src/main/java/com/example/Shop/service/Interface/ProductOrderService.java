package com.example.Shop.service.Interface;

import com.example.Shop.model.Order;

import java.util.List;

public interface ProductOrderService {
    void CreateProductOrder(Order order);
    List<Order> getAllOrder();
    void deleteOrder(long id);
    void updateOrder(Order updatedOrder, long id);
    List<Order> getOrderByUserId(long userId);

}