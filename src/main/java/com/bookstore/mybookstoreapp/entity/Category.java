package com.bookstore.mybookstoreapp.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1)
    @NotEmpty
    private String categoryName;

    @OneToMany
    private Set <Book> books;

    public Category(){};

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Set<Book> getBooks() {
        return books;
    }
}
