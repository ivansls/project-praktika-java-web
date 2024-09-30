package com.web_project.school.model;


import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "university")
public class UniversityModel {
    @Id
    @GeneratedValue
    private UUID Id;
    private String name;

    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    private List<StudentModel> students;

    public UniversityModel(){

    }

    public UniversityModel(UUID id, String name, List<StudentModel> students) {
        Id = id;
        this.name = name;
        this.students = students;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentModel> getStudents() {
        return students;
    }

    public void setStudents(List<StudentModel> students) {
        this.students = students;
    }
}
