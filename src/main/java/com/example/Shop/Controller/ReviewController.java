
package com.example.Shop.Controller;

import com.example.Shop.Dto.ProductRatingDTO;
import com.example.Shop.model.Product;
import com.example.Shop.model.ProductReview;
import com.example.Shop.service.Interface.ProductReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class ReviewController {
    @Autowired
    private ProductReviewService prs;

    @PostMapping(path = "/Review")
    public void createProductReview(@Valid @RequestBody ProductReview productReview) {
        prs.createProductReview(productReview);
    }

    @GetMapping(path = "/Review")
    public List<ProductReview> getAllProductReview() {
        return prs.getAllProductReview();
    }

    @DeleteMapping(path = "/Review/{productId}")
    public void deleteProductReview(@PathVariable long productId) {
        prs.deleteProductReview(productId);
    }

//    @PutMapping(path = "/productReview/{id}")
//    public void updateReview(@RequestBody ProductReview productReview, @PathVariable String id) {
//        prs.updateReview(productReview, id);
//    }

    @GetMapping(path = "/Review/rating/{rating}")
    public List<ProductReview>getRatingLessThan(@PathVariable double rating){
        return prs.getRatingLessThan(rating);
    }

//New Line
@GetMapping("/average-rating/{productId}")
public ResponseEntity<ProductRatingDTO> getAverageRatingByProductId(@PathVariable Long productId) {
    ProductRatingDTO averageRating = prs.getAverageRatingByProductId(productId);
    return ResponseEntity.ok(averageRating);
}

}
