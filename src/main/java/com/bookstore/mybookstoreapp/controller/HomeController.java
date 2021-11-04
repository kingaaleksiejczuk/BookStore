package com.bookstore.mybookstoreapp.controller;

import com.bookstore.mybookstoreapp.dto.BookDTO;
import com.bookstore.mybookstoreapp.entity.Book;
import com.bookstore.mybookstoreapp.entity.User;
import com.bookstore.mybookstoreapp.helper.DataHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

public class HomeController {

    @Autowired
    private DataHelper dataHelper;
    @Autowired
    private BookDTO bookDTO;

//    @RequestMapping("/")
//    public String home(Principal principal, Model model, HttpSession session){
//        User user = dataHelper.getRequiredHeaderInfo(principal,model);
//        if(user != null){
//            List<Book> books = dataHelper.getBooksByFollowedCatsAndUsers(principal,model);
//            if(books.size() == 0){
//                model.addAttribute("nobooks", true);
//            }
//            dataHelper.getUserVotesSendToView(user,model);
//        }
//        return
//    }
}
