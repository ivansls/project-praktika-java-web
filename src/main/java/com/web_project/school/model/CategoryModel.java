package com.web_project.school.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "categories")
public class CategoryModel {
    @Id
    @GeneratedValue
    private UUID Id;
    private String CategoryName;

    @ManyToMany
    @JoinTable(name = "book_category",
            joinColumns = @JoinColumn(name = "category_Id"),
            inverseJoinColumns = @JoinColumn(name = "book_Id"))
    private List<BookModel> books;


    public CategoryModel() {
    }

    public CategoryModel(UUID id, String categoryName, List<BookModel> books) {
        Id = id;
        CategoryName = categoryName;
        this.books = books;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }
}
