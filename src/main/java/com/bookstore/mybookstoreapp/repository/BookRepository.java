package com.bookstore.mybookstoreapp.repository;

import com.bookstore.mybookstoreapp.entity.Book;
import com.bookstore.mybookstoreapp.entity.Category;
import com.bookstore.mybookstoreapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;

@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByCategoryOrderByCreatedDesc(Category category);

    List<Book> findAllByOrderByCreatedDesc();

    List<Book> findAllByCategoryInOrUserInOrderByCreatedDesc(Set<Category> categories, Set<User> userList);

    List<Book> findAllByUserInOrderByCreatedDesc(List<User> users);

    List<Book> findAllByCategoryInOrderByCreatedDesc(Set<Category> categories);
}
