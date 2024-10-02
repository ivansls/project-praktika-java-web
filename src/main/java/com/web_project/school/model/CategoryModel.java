package com.web_project.school.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "categories")
public class CategoryModel {
    @Id
    @GeneratedValue
    private UUID id;
    private String categoryName;
    @ManyToMany
    @JoinTable(name = "book_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<BookModel> books;

    public CategoryModel() {
    }

    public CategoryModel(UUID id, String categoryName, List<BookModel> books) {
        this.id = id;
        this.categoryName = categoryName;
        this.books = books;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }
}
