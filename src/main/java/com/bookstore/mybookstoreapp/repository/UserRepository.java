package com.bookstore.mybookstoreapp.repository;

import com.bookstore.mybookstoreapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findUserByEmail(String email);

    List<User> getAllByOrderByPointsDesc();

    Long countUsersByUsername(String username);

    Long countUsersByEmail(String email);

}
