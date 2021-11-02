package com.bookstore.mybookstoreapp.repository;

import com.bookstore.mybookstoreapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
