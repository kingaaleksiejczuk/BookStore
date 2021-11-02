package com.bookstore.mybookstoreapp.helper;

import com.bookstore.mybookstoreapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataHelper {

    private UserService userService;

    public boolean isEmailUnique(String email) {
        Long userCount = userService.isEmailUnique(email);
        return userCount > 0 ? false : true;
    }



}
