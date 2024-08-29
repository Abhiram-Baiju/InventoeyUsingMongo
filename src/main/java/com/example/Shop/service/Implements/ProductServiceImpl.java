package com.example.Shop.service.Implements;

import com.example.Shop.Dto.ProductDetailsDTO;
import com.example.Shop.Dto.ReviewDTO;
import com.example.Shop.Dto.SearchProductDTO;
import com.example.Shop.model.Product;
import com.example.Shop.model.ProductCategory;
import com.example.Shop.model.ProductReview;
import com.example.Shop.model.User;
import com.example.Shop.repository.ReviewRepo;
import com.example.Shop.repository.ShopRepo;
import com.example.Shop.service.Interface.ProductService;
import com.example.Shop.service.Interface.sequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ShopRepo shopRepo;
    @Autowired
    private sequenceGeneratorService sg;
    @Autowired
    private ReviewRepo reviewRepo;
    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void createProduct(Product product) {
        product.setProductId(sg.generateSequence(product.SEQUENCE_NAME));
        shopRepo.save(product);
    }

    @Override
    public List<Product> getProductByPriceGreaterThanAndName(Double minPrice, String name) {
        return shopRepo.findByPriceGreaterThanAndName(minPrice, name);
    }

    @Override
    public List<Product> getAllProduct() {
        return shopRepo.findAll();
    }

    @Override
    public void deleteProduct(long productId) {
        shopRepo.deleteById(productId);
    }

    @Override
    public void updateProduct(Product updatedProduct, long id) {
        shopRepo.findById(id).map(product -> {
            product.setProductId(updatedProduct.getProductId());
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setCategory(updatedProduct.getCategory());
//          product.setCategoryId(updatedProduct.get);
            product.setQuantity(updatedProduct.getQuantity());
            return shopRepo.save(product);
        }).orElseThrow(() -> new RuntimeException("Product not found" + id));
    }

    @Override
    public List<Product> getProductByPriceGreaterThanAndName(double price, String name) {
        return shopRepo.findByPriceGreaterThanAndName(price, name);
    }

    @Override
    public List<Product> getProductByPriceGreaterThan(double price) {
        return shopRepo.findByPriceGreaterThan(price);
    }

    @Override
    public List<Product> getProductByName(String name) {
        return shopRepo.findByName(name);
    }


    private ProductCategory fetchCategoryById(long categoryId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("categoryId").is(categoryId));
        return mongoOperations.findOne(query, ProductCategory.class);
    }

//    private List<ProductReview> fetchReviewsByProductId(long productId) {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("productId").is(productId));
//        return mongoOperations.find(query, ProductReview.class);
//    }

//    private ProductDetailsDTO mapToProductDetailsDTO(Product product) {
//        ProductDetailsDTO dto = new ProductDetailsDTO();
//       dto.setProductId(product.getProductId());
//        dto.setName(product.getName());
//        dto.setPrice(product.getPrice());
//        //dto.setCategoryId(product.getCategory().getCategoryId());
//        dto.setCategoryName(product.getCategory().getCategoryName());
//        dto.setRating(product.getReview());
//        dto.setQuantity(product.getQuantity());
//
//        List<ReviewDTO> reviewDTOs = product.getReview().stream()
//                .map(this::mapToReviewDTO)
//                .collect(Collectors.toList());
//        dto.setReviews(reviewDTOs);
//        return dto;
//    }




    private double calculateAverageRating(Product product) {
        List<ProductReview> reviews = product.getReview();
        if (reviews != null && !reviews.isEmpty()) {
            return reviews.stream()
                    .mapToDouble(ProductReview::getRating)
                    .average()
                    .orElse(0.0);
        }
        return 0.0; // Return default if no reviews or ratings available
    }
/////////////////////////////////////////////////////////
private ProductDetailsDTO mapToProductDetailsDTO(Product product) {
    ProductDetailsDTO dto = new ProductDetailsDTO();
    dto.setProductId(product.getProductId());
    dto.setName(product.getName());
    dto.setPrice(product.getPrice());
    //dto.setCategoryId(product.getCategory().getCategoryId());
    dto.setCategoryName(product.getCategory().getCategoryName());
    dto.setReviewDTO(product.getReview());
    dto.setQuantity(product.getQuantity());
   // double calculateAverageRating;
    dto.setAverageRating(calculateAverageRating(product));
    List<ReviewDTO> reviewDTOs = product.getReview().stream()
            .map(this::mapToReviewDTO)
            .collect(Collectors.toList());
    dto.setReviewDTO(reviewDTOs);
    return dto;
}
/////////////////////////////////////////////////////////


    private ReviewDTO mapToReviewDTO(ProductReview review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setReviewId(review.getReviewId());
        dto.setReviewText(review.getReviewText());
        dto.setRating(review.getRating());
        if (review.getUser() != null) {
            dto.setUserName(review.getUser().getName());
        } else {
            dto.setUserName("Unknown User"); // or handle it in a way that fits your application's needs
        }//NL
        return dto;
    }
//product.getCategory().getCategoryName()
    @Override
    public List<Product> searchProducts(SearchProductDTO searchProductDTO) {
        String name = searchProductDTO.getName();
        Double minPrice = searchProductDTO.getMinPrice();

        if (name != null && minPrice != null) {
            return shopRepo.findByPriceGreaterThanAndName(minPrice, name);
        } else if (name != null) {
            return shopRepo.findByName(name);
        } else if (minPrice != null) {
            return shopRepo.findByPriceGreaterThan(minPrice);
        } else {
            return shopRepo.findAll();
        }
    }

    @Override
    public List<ProductDetailsDTO> getProductsWithLowRating(Double rating) {
        List<Product> products = shopRepo.findAll();
        for (Product product : products) {
            product.setCategory(fetchCategoryById(product.getCategory().getCategoryId()));
            product.setReview(fetchReviewsByProductId(product.getProductId()));
        }

        // Filter products based on rating and map to DTOs
        return products.stream()
                .filter(product -> product.getReview().stream()
                        .mapToDouble(review -> review.getRating() != null ? review.getRating() : 0)
                        .average()
                        .orElse(0) < rating)
                .map(this::mapToProductDetailsDTO)
                .collect(Collectors.toList());
    }

    private List<ProductReview> fetchReviewsByProductId(long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        List<ProductReview> reviews = mongoOperations.find(query, ProductReview.class);

        // Fetch user details for each review
        for (ProductReview review : reviews) {
            if (review.getUserId() != 0) {
                Query userQuery = new Query();
                userQuery.addCriteria(Criteria.where("userId").is(review.getUserId()));
                User user = mongoOperations.findOne(userQuery, User.class);
                review.setUser(user);
            }
        }

        return reviews;
    }



}
