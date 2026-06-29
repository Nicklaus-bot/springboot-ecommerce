package com.ecommerce_backend.controller;

import com.ecommerce_backend.model.Category;
import com.ecommerce_backend.service.CategoryService;
import com.ecommerce_backend.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/categories")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @PostMapping("/api/admin/category")
    public String createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return "Category Created";
    }




}
