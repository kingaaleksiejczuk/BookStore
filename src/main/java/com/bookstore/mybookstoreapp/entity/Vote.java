package com.bookstore.mybookstoreapp.entity;

import com.bookstore.mybookstoreapp.dto.BookDTO;
import com.bookstore.mybookstoreapp.dto.ReviewDTO;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private Integer voted;   // 2=voted up; 1=voted down; 0=no vote

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "review_id")
    private Review review;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;

    public Vote() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVoted() {
        return voted;
    }

    public void setVoted(Integer voted) {
        this.voted = voted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isVoteForBook(BookDTO book) {
        return this.book == book.getBook();
    }
    public boolean isVoteForReview(ReviewDTO review) {
        return this.review == review.getReview();
    }
}
