
package com.example.Shop.service.Implements;
import com.example.Shop.Dto.ProductRatingDTO;
import com.example.Shop.model.Product;
import com.example.Shop.model.ProductReview;
import com.example.Shop.repository.ReviewRepo;
import com.example.Shop.service.Interface.ProductReviewService;
import com.example.Shop.service.Interface.sequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductReviewImpl implements ProductReviewService {
    @Autowired
    private ReviewRepo reviewRepo;
    @Autowired
    private sequenceGeneratorService sg;

    public void createProductReview(ProductReview productReview) {
        productReview.setReviewId(sg.generateSequence(productReview.SEQUENCE_NAME));
        reviewRepo.save(productReview);
    }

    public List<ProductReview> getAllProductReview() {
        return reviewRepo.findAll();
    }

    public void updateReview(ProductReview updatedProductReview, long id) {
        reviewRepo.findById(id).map(productReview -> {
            productReview.setReviewText(updatedProductReview.getReviewText());
            productReview.setRating(updatedProductReview.getRating());
            return reviewRepo.save(productReview);
        }).orElseThrow(() -> new RuntimeException("ProductReview not found with id " + id));}


    public void deleteProductReview(long id) {
        reviewRepo.deleteById(id);
    }

    public List<ProductReview> getRatingLessThan(double rating) {
        return reviewRepo.findByRatingLessThan(rating);
    }
//newLine
@Override
public ProductRatingDTO getAverageRatingByProductId(Long productId) {
    List<ProductReview> reviews = reviewRepo.findByProductId(productId);

    Double averageRating = reviews.stream().mapToDouble(ProductReview::getRating).average().orElse(0.0);
    Product product = reviews.get(0).getProduct();
//    String name = product.getName();
    return new ProductRatingDTO(averageRating);//,name
}

}

