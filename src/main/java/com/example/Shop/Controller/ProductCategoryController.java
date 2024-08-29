package com.example.Shop.Controller;

import com.example.Shop.model.Product;
import com.example.Shop.model.ProductCategory;
import com.example.Shop.service.Interface.ProductCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService pcs;

    @PostMapping(path = "/productCategory")
    public void CreateProductCategory(@Valid @RequestBody ProductCategory productCategory){
        pcs.CreateaProductCategory(productCategory);
    }

    @GetMapping(path = "/productCategory")
    public List<ProductCategory> getAllcategory()
    {
        return pcs.getAllcategory();
    }

    @PutMapping(path = "/productCategory/{categoryId}")
    public void updateProductCategory(@RequestBody ProductCategory productCategory,@PathVariable long categoryId){
        pcs.updateProductCategory(productCategory,categoryId);
    }

    @DeleteMapping(path = "productCategory/{categoryId}")
    public void deleteProductCategory(@PathVariable long categoryId){
        pcs.deleteProductCategory(categoryId);
    }

}