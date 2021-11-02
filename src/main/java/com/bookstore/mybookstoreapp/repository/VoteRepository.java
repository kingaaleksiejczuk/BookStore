package com.bookstore.mybookstoreapp.repository;

import com.bookstore.mybookstoreapp.entity.User;
import com.bookstore.mybookstoreapp.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    List <Vote> findAllByUser(User user);
}
