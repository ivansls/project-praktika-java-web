package com.web_project.school.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;


@Entity
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Size(min = 3, message = "name size error")
    private String Name;
    @Size(min = 3, message = "firstname size error")
    private String FirstName;
    @Nullable
    private String LastName;
    @Nullable
    @Email(message = "not email")
    private String CorpEmail;


    public StudentModel(){

    }

    public StudentModel(Long id, String name, String firstName, @Nullable String lastName, @Nullable String corpEmail) {
        Id = id;
        Name = name;
        FirstName = firstName;
        LastName = lastName;
        CorpEmail = corpEmail;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public @Size(min = 3, message = "name size error") String getName() {
        return Name;
    }

    public void setName(@Size(min = 3, message = "name size error") String name) {
        Name = name;
    }

    public @Size(min = 3, message = "firstname size error") String getFirstName() {
        return FirstName;
    }

    public void setFirstName(@Size(min = 3, message = "firstname size error") String firstName) {
        FirstName = firstName;
    }

    @Nullable
    public String getLastName() {
        return LastName;
    }

    public void setLastName(@Nullable String lastName) {
        LastName = lastName;
    }

    @Nullable
    public @Email(message = "not email") String getCorpEmail() {
        return CorpEmail;
    }

    public void setCorpEmail(@Nullable @Email(message = "not email") String corpEmail) {
        CorpEmail = corpEmail;
    }
}
