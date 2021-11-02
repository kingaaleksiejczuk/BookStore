package com.bookstore.mybookstoreapp.dto;

import com.bookstore.mybookstoreapp.entity.Review;
import com.bookstore.mybookstoreapp.entity.Vote;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ReviewDTO {

    private Review review;
    private Vote vote;

    public ReviewDTO addUserVote(List<Vote> userVotes){
        userVotes.stream()
                .filter(vote -> vote.isVoteForReview(this))
                .findFirst().ifPresent(this::setVote);
        return this;
    }
}
