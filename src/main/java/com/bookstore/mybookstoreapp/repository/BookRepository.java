package com.bookstore.mybookstoreapp.repository;

import com.bookstore.mybookstoreapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book, Long> {






}
