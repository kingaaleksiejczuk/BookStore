package com.bookstore.mybookstoreapp.helper;

import com.bookstore.mybookstoreapp.entity.*;
import com.bookstore.mybookstoreapp.service.BookService;
import com.bookstore.mybookstoreapp.service.CategoryService;
import com.bookstore.mybookstoreapp.service.UserService;
import com.bookstore.mybookstoreapp.service.VoteService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.*;

@Component
public class DataHelper {

    private UserService userService;
    private CategoryService categoryService;
    private BookService bookService;
    private VoteService voteService;

    public boolean isEmailUnique(String email) {
        Long userCount = userService.isEmailUnique(email);
        return userCount > 0 ? false : true;
    }

    public void setAppContext(String appContext, Model model) {
        model.addAttribute("appContext", appContext);
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

    public void setTodaysDate(Model model) {
        Date date = new Date();
        model.addAttribute("now", date);
    }

    public Category getCategoryById(Long id) {
        return categoryService.getCategoryById(id);
    }

    public User getUserById(Long id) {
        return userService.getUserById(id);
    }

    public boolean isUserUnique(String username) {
        Long userCount = userService.isUserUnique(username);
        return userCount > 0 ? false : true;
    }

    public User getUserSendToView(Principal principal, Model model) {
        if (principal != null) {
            Optional<User> findUser = userService.getUserByEmail(principal.getName());
            if (findUser.isPresent()) {
                User user = findUser.get();
                user.setLogged(1);
                model.addAttribute("user", user);
                return user;
            }
        }
        return null;
    }

    public List<Category> getAllCategoriesAndSendToView(Model model) {
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);
        return categories;
    }

    public User getRequiredHeaderInfo(Principal principal, Model model) {
        User user = getUserSendToView(principal, model);
        setTodaysDate(model);
        getAllCategoriesAndSendToView(model);

        return user;
    }

    public List<Book> getBooksByFollowedCatsAndUsers(Principal principal, Model model) {
        User user = getUserSendToView(principal, model);
        List<Book> books = bookService.getBooksByFollowedCatsAndUsers(user.getCategories(), user.getSubbedToUsers());
        return books;
    }

    public List<Vote> getUserVotesSendToView(User user, Model model) {
        List<Vote> userVotes = voteService.getVotedByUser(user);
        model.addAttribute("userVotes", userVotes);
        return userVotes;
    }

}
