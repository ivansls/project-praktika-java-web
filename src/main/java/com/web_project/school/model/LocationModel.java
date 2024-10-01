package com.web_project.school.model;


import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table(name = "location")
public class LocationModel {
    @jakarta.persistence.Id
    @GeneratedValue
    private UUID Id;
    private String Shelf;
    private String RowNumber;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_Id")
    private BookModel book;


    public LocationModel() {
    }

    public LocationModel(UUID id, String shelf, String rowNumber, BookModel book) {
        Id = id;
        Shelf = shelf;
        RowNumber = rowNumber;
        this.book = book;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getShelf() {
        return Shelf;
    }

    public void setShelf(String shelf) {
        Shelf = shelf;
    }

    public String getRowNumber() {
        return RowNumber;
    }

    public void setRowNumber(String rowNumber) {
        RowNumber = rowNumber;
    }

    public BookModel getBook() {
        return book;
    }

    public void setBook(BookModel book) {
        this.book = book;
    }
}
