package com.web_project.school.model;


import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "courses")
public class CoursesModel {
    @Id
    @GeneratedValue
    private UUID Id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private UsersModel teacher;

    @OneToMany(mappedBy = "course")
    private List<AssignmentsModel> assignments;

    @OneToMany(mappedBy = "course")
    private List<EnrollmentsModel> enrollments;

    public CoursesModel() {}


    public CoursesModel(String name, String description, UsersModel teacher, List<AssignmentsModel> assignments, List<EnrollmentsModel> enrollments) {
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.assignments = assignments;
        this.enrollments = enrollments;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UsersModel getTeacher() {
        return teacher;
    }

    public void setTeacher(UsersModel teacher) {
        this.teacher = teacher;
    }

    public List<AssignmentsModel> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<AssignmentsModel> assignments) {
        this.assignments = assignments;
    }

    public List<EnrollmentsModel> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<EnrollmentsModel> enrollments) {
        this.enrollments = enrollments;
    }
}
