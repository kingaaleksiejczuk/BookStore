package com.bookstore.mybookstoreapp.dto;
import com.bookstore.mybookstoreapp.entity.Book;
import com.bookstore.mybookstoreapp.entity.Review;
import com.bookstore.mybookstoreapp.entity.Vote;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class BookDTO {

    private Book book;
    private Vote vote;
    private List<ReviewDTO> reviews;

    public BookDTO addVote(List<Vote> userVotes){
        userVotes.stream()
                .filter(vote -> vote.isVoteForBook(this))
                .findFirst().ifPresent(this::setVote);
        return this;
    }

    public BookDTO addReviews(){
        List<Review> bookReviews = this.book.getReviews();
        List<ReviewDTO> buildReview = new ArrayList<>();
        if(bookReviews != null){
            for(Review r : bookReviews){
                buildReview.add(Review.mapToReviewDTO(r));
            }
        }
        reviews = buildReview;
        return this;
    }

    public Book getBookFromDTO(){
        return this.book;
    }
}
