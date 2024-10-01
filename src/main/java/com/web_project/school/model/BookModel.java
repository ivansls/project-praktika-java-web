package com.web_project.school.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "books")
public class BookModel {

    @Id
    @GeneratedValue
    private UUID Id;
    private String Title;
    private String PublicationYear;

    @OneToOne(optional = false, mappedBy = "book")
    private LocationModel owner;

    @ManyToOne
    @JoinColumn(name = "author_Id")
    private AuthorModel authors;


    @ManyToMany
    @JoinTable(name = "book_category",
            joinColumns = @JoinColumn(name = "book_Id"),
            inverseJoinColumns = @JoinColumn(name = "category_Id"))
    private List<CategoryModel> categories;


    public BookModel() {
    }

    public BookModel(UUID id, String title, String publicationYear, LocationModel owner, AuthorModel authors, List<CategoryModel> categories) {
        Id = id;
        Title = title;
        PublicationYear = publicationYear;
        this.owner = owner;
        this.authors = authors;
        this.categories = categories;
    }


    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPublicationYear() {
        return PublicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        PublicationYear = publicationYear;
    }

    public LocationModel getOwner() {
        return owner;
    }

    public void setOwner(LocationModel owner) {
        this.owner = owner;
    }

    public AuthorModel getAuthor() {
        return authors;
    }

    public void setAuthor(AuthorModel authors) {
        this.authors = authors;
    }

    public List<CategoryModel> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryModel> categories) {
        this.categories = categories;
    }
}
