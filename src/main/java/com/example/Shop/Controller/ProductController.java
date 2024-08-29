package com.example.Shop.Controller;

import com.example.Shop.Dto.ProductDetailsDTO;
import com.example.Shop.Dto.SearchProductDTO;
import com.example.Shop.model.Product;
import com.example.Shop.service.Implements.ProductServiceImpl;
import com.example.Shop.service.Interface.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@Validated
public class ProductController {
    @Autowired
    private ProductService ps;

    @PostMapping
    public void createProduct(@Valid @RequestBody Product product) {
        ps.createProduct(product);
    }

    @GetMapping
    public List<Product> getAllProduct() {
        return ps.getAllProduct();
    }

    @DeleteMapping(path = "/product/{productId}")
    public void deleteProduct(@PathVariable long productId) {
        ps.deleteProduct(productId);
    }

    @PutMapping(path = "/product/{productId}")
    public void updateProduct(@RequestBody Product product, @PathVariable long productId) {
        ps.updateProduct(product, productId);
    }

    @GetMapping("/product-search")
    public List<Product> searchProducts(@RequestParam(required = false) String name,
                                        @RequestParam(required = false) Double minPrice) {
        SearchProductDTO searchProductDTO = new SearchProductDTO();
        searchProductDTO.setName(name);
        searchProductDTO.setMinPrice(minPrice);
        return ps.searchProducts(searchProductDTO);
    }

    @GetMapping("/low-rating/{rating}")
    public List<ProductDetailsDTO> getProductsWithLowRating(@PathVariable Double rating) {
        return ps.getProductsWithLowRating(rating);
    }

}


    // Get products with low ratings
//    @GetMapping("/low-rating")
//    public List<ProductDetailsDTO> getProductsWithLowRating(@RequestParam double ratingThreshold) {
//        ProductService productService;
//        return ps.getProductsDetailsWithLowRating(ratingThreshold);
//    }
//}

//
//http://localhost:8081/product/search?name=Keyboard
//        http://localhost:8081/product/search
//        http://localhost:8081/product/search?minPrice=500
