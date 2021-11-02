package com.bookstore.mybookstoreapp.service;

import com.bookstore.mybookstoreapp.entity.Review;

import java.util.List;

public interface ReviewService {

    void saveReview(Review review);

    List<Review> getAllReviews();

    List<Review> getAllFromNewest();

    Review getReviewById(Long id);

}
