package com.web_project.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "authors")
public class AuthorModel {
    @Id
    @GeneratedValue
    private UUID Id;
    private String AuthorName;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @OneToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    private List<BookModel> books;

    public AuthorModel() {
    }

    public AuthorModel(UUID id, String authorName, List<BookModel> books) {
        Id = id;
        AuthorName = authorName;
        this.books = books;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }
}
