package com.ecommerce_backend.service;

import com.ecommerce_backend.model.Category;
import java.util.List;

//used interface to maintain loose coupling
public interface CategoryService {
    List<Category> getCategories();
    void createCategory(Category category);
    String deleteCategory(Long categoryId);
    Category updateCategory(Category category , Long categoryId);
}
