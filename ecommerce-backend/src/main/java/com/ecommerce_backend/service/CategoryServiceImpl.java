package com.ecommerce_backend.service;

import com.ecommerce_backend.model.Category;
import com.ecommerce_backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category deleteCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND , "Resource not Found"));

        categoryRepository.delete(deleteCategory);
        return "Category with categoryId " + categoryId + " deleted Successfully!";
    }

    @Override
    public Category updateCategory(Category category , Long categoryId) {
        Category saveCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND , "Resource Not Found"));

        category.setCategoryName(saveCategory.getCategoryName());
        categoryRepository.save(category);
        return category;
    }


}
