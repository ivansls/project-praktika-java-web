package com.web_project.school.model;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "pasport")
public class PasportModel {
    @Id
    @GeneratedValue
    private UUID Id;
    private String series;
    private String number;


    @OneToOne(optional = false, mappedBy = "pasport")
    private StudentModel owner;

    public PasportModel(){

    }

    public PasportModel(UUID id, String series, String number, StudentModel owner) {
        Id = id;
        this.series = series;
        this.number = number;
        this.owner = owner;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public StudentModel getOwner() {
        return owner;
    }

    public void setOwner(StudentModel owner) {
        this.owner = owner;
    }
}
