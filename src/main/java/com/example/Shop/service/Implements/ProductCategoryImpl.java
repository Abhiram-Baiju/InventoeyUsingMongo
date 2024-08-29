package com.example.Shop.service.Implements;

import com.example.Shop.model.ProductCategory;
import com.example.Shop.repository.ProductCategoryRepo;
import com.example.Shop.service.Interface.ProductCategoryService;
import com.example.Shop.service.Interface.sequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductCategoryImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepo categoryRepo;

    @Autowired
    private sequenceGeneratorService sg;

    @Override
    public void CreateaProductCategory(ProductCategory productCategory) {

        productCategory.setCategoryId(sg.generateSequence(productCategory.SEQUENCE_NAME));
        categoryRepo.save(productCategory);
    }
    @Override
    public List<ProductCategory> getAllcategory() {
        return categoryRepo.findAll();
    }
    @Override
    public void deleteProductCategory(long categoryId) {
        categoryRepo.deleteById(categoryId);
    }
    @Override
    public void updateProductCategory(ProductCategory updateProductCategory,long categoryId) {
        categoryRepo.findById(categoryId).map(productCategory -> {
            productCategory.setCategoryId(updateProductCategory.getCategoryId());
            productCategory.setCategoryName(updateProductCategory.getCategoryName());
            return categoryRepo.save(productCategory);
        }).orElseThrow(() -> new RuntimeException("Product not found with id " + categoryId));
    }
}