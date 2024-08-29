package com.example.Shop.service.Interface;

import com.example.Shop.Dto.ProductDetailsDTO;
import com.example.Shop.Dto.SearchProductDTO;
import com.example.Shop.model.Product;

import java.util.List;

public interface ProductService {
    void createProduct(Product product);
    List<Product> getProductByPriceGreaterThanAndName(Double minPrice, String name);
    List<Product> getAllProduct();
    void deleteProduct(long productId);
    void updateProduct(Product updatedProduct, long id);
    List<Product> getProductByPriceGreaterThanAndName(double price, String name);
    List<Product> getProductByPriceGreaterThan(double price);
    List<Product> getProductByName(String name);
    List<Product> searchProducts(SearchProductDTO searchProductDTO);
    List<ProductDetailsDTO> getProductsWithLowRating(Double rating);
}
