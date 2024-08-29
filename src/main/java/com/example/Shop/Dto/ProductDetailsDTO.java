package com.example.Shop.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
//public class ProductDetailsDTO<productReview> {
//    private long productId;
//    private String name;
//    private double price;
//    private double quantity;
//    private String categoryName;
//    private List<productReview> rating;
//
//    public void setReviews(List<ReviewDTO> reviewDTOs) {
//    }
//
//}
public class ProductDetailsDTO<ReviewDTO> {
    private long productId;
    private String name;
    private double price;
    private double quantity;
    private String categoryName;
    private Double averageRating;

    //    private List<productReview> rating;
    private List<ReviewDTO> reviewDTO;

    public void setReviews(List<ReviewDTO> reviewDTOs) {
    }


}
