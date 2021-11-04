package com.bookstore.mybookstoreapp.entity;

import com.bookstore.mybookstoreapp.dto.ReviewDTO;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Book book;

    @Size(min = 1)
    private String reviewText;

    @OneToMany(mappedBy = "review")
    private Set<Vote> votes;

    private Long points;

    private Date date;

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public Set<Vote> getVotes() {
        return votes;
    }

    public String getReviewText() {
        return reviewText;
    }

    public Long getPoints() {
        return points;
    }

    public Date getDate() {
        return date;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static ReviewDTO mapToReviewDTO(Review review) {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setReview(review);
        return reviewDTO;
    }

}
