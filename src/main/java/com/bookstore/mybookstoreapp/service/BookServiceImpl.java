package com.bookstore.mybookstoreapp.service;

import com.bookstore.mybookstoreapp.entity.Book;
import com.bookstore.mybookstoreapp.entity.Category;
import com.bookstore.mybookstoreapp.entity.User;
import com.bookstore.mybookstoreapp.repository.BookRepository;

import java.util.List;
import java.util.Set;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> getBooksByCat(Category category) {
        return bookRepository.findAllByCategoryOrderByCreatedDesc(category);
    }

    @Override
    public List<Book> getAllFromNewest() {
        return bookRepository.findAllByOrderByCreatedDesc();
    }

    @Override
    public List<Book> getBooksByFollowedCatsAndUsers(Set<Category> categories, Set<User> users) {
        return bookRepository.findAllByCategoryInOrUserInOrderByCreatedDesc(categories, users);
    }

    @Override
    public List<Book> getBooksForUserBySubsCats(Set<Category> categories) {
        return bookRepository.findAllByCategoryInOrderByCreatedDesc(categories);
    }

    @Override
    public List<Book> getBookForUsersSubs(List<User> userList) {
        return bookRepository.findAllByUserInOrderByCreatedDesc(userList);
    }

}
