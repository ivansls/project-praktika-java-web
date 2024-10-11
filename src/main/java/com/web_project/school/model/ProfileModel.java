package com.web_project.school.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "profiles")
public class ProfileModel {
    @Id
    @GeneratedValue
    private UUID id;
    private String phoneNumber;
    private String address;


    @Nullable
    @OneToOne(optional = false, mappedBy = "profile")
    private UsersModel user;

    public ProfileModel() {}


    public ProfileModel(UsersModel user, String phoneNumber, String address) {
        this.user = user;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UsersModel getUser() {
        return user;
    }

    public void setUser(UsersModel user) {
        this.user = user;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getters and Setters
}