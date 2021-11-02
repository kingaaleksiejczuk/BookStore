package com.bookstore.mybookstoreapp.helper;

import com.bookstore.mybookstoreapp.entity.Role;
import com.bookstore.mybookstoreapp.entity.User;
import com.bookstore.mybookstoreapp.service.UserService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataHelper {

    private UserService userService;

    public boolean isEmailUnique(String email) {
        Long userCount = userService.isEmailUnique(email);
        return userCount > 0 ? false : true;
    }

    public void setAppContext(String appContext, Model model) {
//        model.addAttribute("appContext", appContext);
    }

    public void saveNewUser(User user){
        Set<Role> roles = new HashSet<>();
        roles.add(Role.USER);
        user.setRoles(roles);
        user.setPoints(0L);
        user.setJoined(new Date());
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userService.saveUser(user);
    }
}
