
package com.example.Shop.repository;

import com.example.Shop.model.ProductCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductCategoryRepo extends MongoRepository <ProductCategory,Long> {
}
