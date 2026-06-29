package com.ecommerce_backend.controller;

import com.ecommerce_backend.model.Category;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    private List<Category> categories = new ArrayList<>();

    @GetMapping("/api/public/categories")
    public List<Category> getCategories(){
        return categories;
    }

    @PostMapping("/api/admin/category")
    public String createCategory(@RequestBody Category category){
        categories.add(category);
        return "Category Added Successfully";
    }




}
