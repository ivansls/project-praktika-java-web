package com.web_project.school.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "books")
public class BookModel {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String publicationYear;
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private LocationModel location;
    @ManyToOne
    @JoinColumn(name = "authors_id")
    private AuthorModel authors;
    @ManyToMany
    @JoinTable(name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoryModel> categories;

    public BookModel() {
    }

    public BookModel(UUID id, String title, String publicationYear, LocationModel location, AuthorModel authors, List<CategoryModel> categories) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
        this.location = location;
        this.authors = authors;
        this.categories = categories;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public LocationModel getLocation() {
        return location;
    }

    public void setLocation(LocationModel location) {
        this.location = location;
    }

    public AuthorModel getAuthors() {
        return authors;
    }

    public void setAuthors(AuthorModel authors) {
        this.authors = authors;
    }

    public List<CategoryModel> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryModel> categories) {
        this.categories = categories;
    }
}
