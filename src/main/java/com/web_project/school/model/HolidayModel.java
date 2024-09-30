package com.web_project.school.model;


import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "holidays")
public class HolidayModel {
    @jakarta.persistence.Id
    @GeneratedValue
    private UUID Id;
    private String name;

    @ManyToMany
    @JoinTable(name = "student_holiday",
            joinColumns = @JoinColumn(name = "holiday_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<StudentModel> students;

    public HolidayModel(UUID id, String name, List<StudentModel> students) {
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

