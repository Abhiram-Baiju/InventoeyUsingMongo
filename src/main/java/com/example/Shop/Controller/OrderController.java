package com.example.Shop.Controller;

import com.example.Shop.model.Order;
import com.example.Shop.service.Interface.ProductOrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private ProductOrderService pOS;

    @PostMapping(path="/Order")
    public void createProductOrder(@Valid @RequestBody Order order){
        pOS.CreateProductOrder(order);
    }
    @GetMapping(path = "/Order")
    public List<Order>getAllOrder(){
        return pOS.getAllOrder();
    }

   @PutMapping(path ="/Order/{productId}")
   public void updateOrder(@RequestBody Order productOrder,@PathVariable long orderId){
        pOS.updateOrder(productOrder,orderId);
   }

    @DeleteMapping(path = "/Order/{productId}")
    public void deleteOrder(@PathVariable long productId){
        pOS. deleteOrder(productId);
    }

    @GetMapping(path ="/Order/{userId}")
    public List<Order> getOrderByUserId(@PathVariable long userId){
        return pOS.getOrderByUserId(userId);
    }


}