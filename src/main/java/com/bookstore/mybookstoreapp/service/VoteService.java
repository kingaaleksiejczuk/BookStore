package com.bookstore.mybookstoreapp.service;

import com.bookstore.mybookstoreapp.entity.User;
import com.bookstore.mybookstoreapp.entity.Vote;

import java.util.List;

public interface VoteService {

    void saveVote(Vote vote);

    List<Vote> getVoteByUser(User user);

    List<Vote> getVotedByUser(User user);
}
