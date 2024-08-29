
package com.example.Shop.service.Interface;

import com.example.Shop.Dto.ProductRatingDTO;
import com.example.Shop.model.ProductReview;

import java.util.List;

public interface ProductReviewService {
    void createProductReview(ProductReview productReview);
    List<ProductReview> getAllProductReview();
    //void updateReview(ProductReview updatedProductReview, String id);
    void deleteProductReview(long reviewId);
    List<ProductReview> getRatingLessThan(double rating);

//    newline
    ProductRatingDTO getAverageRatingByProductId(Long productId);
}
