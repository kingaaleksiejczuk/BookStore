package com.bookstore.mybookstoreapp.service;

import com.bookstore.mybookstoreapp.entity.User;
import com.bookstore.mybookstoreapp.entity.Vote;
import com.bookstore.mybookstoreapp.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Override
    public void saveVote(Vote vote) {
        voteRepository.save(vote);
    }

    @Override
    public List<Vote> getVoteByUser(User user) {
        return voteRepository.findAllByUser(user);
    }

    @Override
    public List<Vote> getVotedByUser(User user) {
        return voteRepository.findAllByUser(user);
    }
}
