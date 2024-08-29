package com.example.Shop.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Product")
public class Product {
    @Transient
    public static final String SEQUENCE_NAME = "product_id";
    @Id
    private long productId;

    @NotEmpty
    private String name;

    @NotNull
    @Digits(integer = 10,fraction = 2,message = "Price must be in Digits")
    private Double price;

    @NotNull
    @Digits(integer = 10,fraction = 2,message = "Quantity must be in Number")
    private Double quantity;



    @DBRef
    private ProductCategory category;

    @DBRef
    private List<ProductReview> review=new ArrayList<>();

    public Product() {
    }

    public Product(String name, double price, double quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }




    public List<ProductReview> getReview() {
        return review;
    }

    public void setReview(List<ProductReview> review) {
        this.review = review;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }


}
