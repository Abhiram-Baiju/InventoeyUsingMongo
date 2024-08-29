//package com.example.Shop.service;
//
//import com.example.Shop.model.ProductReview;
//import com.example.Shop.repository.ReviewRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ProductReviewService {
//    @Autowired
//    private ReviewRepo reviewRepo;
//
//    public void createProductReview(ProductReview productReview) {
//        reviewRepo.save(productReview);
//    }
//
//    public List<ProductReview> getAllProductReview() {
//        return reviewRepo.findAll();
//    }
//
//    public void updateReview(ProductReview updatedProductReview, String id) {
//        reviewRepo.findById(id).map(productReview -> {
//            productReview.setProductId(updatedProductReview.getProductId());
//            productReview.setReviewText(updatedProductReview.getReviewText());
//            productReview.setRating(updatedProductReview.getRating());
//            return reviewRepo.save(productReview);
//        }).orElseThrow(() -> new RuntimeException("ProductReview not found with id " + id));
//    }
//
//    public void deleteProductReview(String id) {
//        reviewRepo.deleteById(id);
//    }
//
//
//    public List<ProductReview> getRatingLessThan(double rating) {
//        return reviewRepo.findByRatingLessThan(rating);
//    }
//
//}
