package com.example.Shop.service.Implements;

import com.example.Shop.model.Order;
import com.example.Shop.repository.OrderRepo;
import com.example.Shop.service.Interface.ProductOrderService;
import com.example.Shop.service.Interface.sequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private sequenceGeneratorService sg;
    @Override
    public void CreateProductOrder(Order order) {
        order.setOrderId(sg.generateSequence(order.SEQUENCE_NAME));
        orderRepo.save(order);
    }
    @Override
    public List<Order> getAllOrder() {
        return orderRepo.findAll();
    }

    @Override
    public void deleteOrder(long id) {
        orderRepo.deleteById(id);
    }

    @Override
    public void updateOrder(Order updatedOrder, long orderId) {
        orderRepo.findById(orderId).map(order -> {
            order.setUserId(updatedOrder.getUserId());
            order.setOrderDate(updatedOrder.getOrderDate());
            order.setStatus(updatedOrder.getStatus());
            order.setTotalAmount(updatedOrder.getTotalAmount());
//            order.setProductId(updatedOrder.getProductId());
            return orderRepo.save(order);
        }).orElseThrow(() -> new RuntimeException("Product not found with orderId " + orderId));
    }


    public List<Order> getOrderByUserId(long userId) {
        return orderRepo.findByUserId(userId);
    }
}