package com.bookstore.mybookstoreapp.controller;

import com.bookstore.mybookstoreapp.entity.User;
import com.bookstore.mybookstoreapp.helper.DataHelper;
import com.bookstore.mybookstoreapp.validator.UserRegisterValidationGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;

public class UserController {

    @Autowired
    private DataHelper dataHelper;

    @GetMapping("/register")
    public String register(Model model, Principal principal){
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        dataHelper.setAppContext("register", model);
        return "main";
    }

    @PostMapping("/register")
        public String postRegister(Model model, Principal principal, @Validated ({UserRegisterValidationGroup.class}) User newUser, BindingResult result){
            if(result.hasErrors()){
                dataHelper.setAppContext("register", model);
            }else{
                dataHelper.saveNewUser(newUser);
                dataHelper.setAppContext("regsuccess", model);
            }
            return "main";
    }
}
