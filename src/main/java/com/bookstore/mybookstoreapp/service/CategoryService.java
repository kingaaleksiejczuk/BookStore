package com.bookstore.mybookstoreapp.service;

import com.bookstore.mybookstoreapp.entity.Category;

import java.util.List;

public interface CategoryService {

    void saveCategory(Category category);

    List<Category> getCategories();

    Category getCategoryById(Long id);


}
