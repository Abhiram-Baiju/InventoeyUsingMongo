//package com.example.Shop.service;
//
//import com.example.Shop.model.ProductCategory;
//import com.example.Shop.repository.ProductCategoryRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ProductCategoryService {
//    @Autowired
//    private ProductCategoryRepo categoryRepo;
//
//
//    public void CreateaProductCategory(ProductCategory productCategory) {
//        categoryRepo.save(productCategory);
//    }
//
//    public List<ProductCategory> getAllcategory() {
//        return categoryRepo.findAll();
//    }
//
//    public void deleteProductCategory(String id) {
//        categoryRepo.deleteById(id);
//    }
//
//    public void updateProductCategory(ProductCategory updateProductCategory,String id) {
//        categoryRepo.findById(id).map(productCategory -> {
//            productCategory.setId(updateProductCategory.getId());
//            productCategory.setName(updateProductCategory.getName());
//            return categoryRepo.save(productCategory);
//        }).orElseThrow(() -> new RuntimeException("Product not found with id " + id));;
//    }
//}
