package com.bookstore.mybookstoreapp.service;

import com.bookstore.mybookstoreapp.entity.Book;
import com.bookstore.mybookstoreapp.entity.Category;
import com.bookstore.mybookstoreapp.entity.User;

import java.util.List;
import java.util.Set;

public interface BookService {

    void saveBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(Long id);

    List<Book> getBooksByCat(Category category);

    List<Book> getAllFromNewest();

    List<Book> getBooksByFollowedCatsAndUsers(Set<Category> categories, Set<User> userList);

    List<Book> getBooksForUserBySubsCats(Set<Category> categories);

    List<Book> getBookForUsersSubs(List<User> users);

}
