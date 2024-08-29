package com.example.Shop.service.Interface;

import com.example.Shop.model.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    void CreateaProductCategory(ProductCategory productCategory);
    List<ProductCategory> getAllcategory();
    void deleteProductCategory(long id);
    void updateProductCategory(ProductCategory updateProductCategory,long id);
}