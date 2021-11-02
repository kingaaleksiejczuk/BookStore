package com.bookstore.mybookstoreapp.service;

import com.bookstore.mybookstoreapp.entity.User;
import com.bookstore.mybookstoreapp.helper.DataHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserByEmail(String email);

    List<User> getAllUsers();

    List<User> getAllUsersOtherThanLoggedIn(User user);

    void saveUser(User user);

    List<User> getTop10Users();

    User getUserById(Long id);

    Long isUserUnique(String username);

    Long isEmailUnique(String email);

}
