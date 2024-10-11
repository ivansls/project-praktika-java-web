package com.web_project.school.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table(name = "locations")
public class LocationModel {
    @Id
    @GeneratedValue
    private UUID id;
    private String shelf;
    private String rowNumber;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @OneToOne(optional = false, mappedBy = "location")
    private BookModel owner;

    public LocationModel() {
    }

    public LocationModel(UUID id, String shelf, String rowNumber, BookModel owner) {
        this.id = id;
        this.shelf = shelf;
        this.rowNumber = rowNumber;
        this.owner = owner;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public String getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(String rowNumber) {
        this.rowNumber = rowNumber;
    }

    public BookModel getOwner() {
        return owner;
    }

    public void setOwner(BookModel owner) {
        this.owner = owner;
    }
}
