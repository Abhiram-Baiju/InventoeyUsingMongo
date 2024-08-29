package com.example.Shop.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.stream.Collectors;

@Document(collection = "Order")
public class Order {
    @Transient
    public static final String SEQUENCE_NAME = "order_id";
    @Id
    private long orderId;
    private long userId;

    @NotNull(message = "enter orderDate")
    private String orderDate;

    @NotNull(message ="enter status")
    private String status;

    @NotNull(message = "Enter total Amount")
    private double totalAmount;

    @DBRef
    private List<Product> productId;

    public Order() {
    }

    public Order(long userId, String orderDate, String status, List<Product> productId, double totalAmount) {
        this.userId = userId;
        this.orderDate = orderDate;
        this.status = status;
        this.productId = productId;
        this.totalAmount = totalAmount;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public List<Long> getProductId() {
        return productId.stream()
                .map(Product::getProductId)
                .collect(Collectors.toList());
    }

    public void setProductId(List<Product> productId) {
        this.productId = productId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}