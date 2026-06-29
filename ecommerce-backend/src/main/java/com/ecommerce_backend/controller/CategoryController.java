package com.ecommerce_backend.controller;

import com.ecommerce_backend.model.Category;
import com.ecommerce_backend.service.CategoryService;
import com.ecommerce_backend.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

//    Get all product categories
    @GetMapping("/api/public/categories")
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> list = categoryService.getCategories();
        return new ResponseEntity<>(list , HttpStatus.OK);
    }

//    Create a new product category
    @PostMapping("/api/admin/category")
    public ResponseEntity<String> createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category Created" , HttpStatus.CREATED);
    }

//    Delete a category
    @DeleteMapping("api/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
        try{
            String status = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(status , HttpStatus.OK);
//            Other ways to return response entity
//            return ResponseEntity.ok(status);
//            return ResponseEntity.status(HttpStatus.OK).body(status);
        }
        catch(ResponseStatusException e){
            return new ResponseEntity<>(e.getReason() , e.getStatusCode());
        }
    }

    @PutMapping("api/admin/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category , @PathVariable Long categoryId){
        try{
            Category updatedCategory = categoryService.updateCategory(category , categoryId);
            return new ResponseEntity<>("Category Updated for " + categoryId , HttpStatus.CREATED);
        }
        catch(ResponseStatusException e){
            return new ResponseEntity<>(e.getReason() , e.getStatusCode());
        }
    }


}
