package com.bookstore.mybookstoreapp.repository;

import com.bookstore.mybookstoreapp.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    List<Review> finAllByOrderByCreatedDesc();
}
