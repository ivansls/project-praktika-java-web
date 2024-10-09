package com.web_project.school.model;


import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "assignments")
public class AssignmentsModel {
    @Id
    @GeneratedValue
    private UUID Id;
    private String name;
    private String description;
    private String finishDate;


    @ManyToOne
    @JoinColumn(name = "course_id")
    private CoursesModel course;

    @OneToMany(mappedBy = "assignment")
    private List<GradesModel> grades;;

    public AssignmentsModel() {}

    public AssignmentsModel(String name, String description, String finishDate, CoursesModel course, List<GradesModel> grades) {
        this.name = name;
        this.description = description;
        this.finishDate = finishDate;
        this.course = course;
        this.grades = grades;
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

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public CoursesModel getCourse() {
        return course;
    }

    public void setCourse(CoursesModel course) {
        this.course = course;
    }

    public List<GradesModel> getGrades() {
        return grades;
    }

    public void setGrades(List<GradesModel> grades) {
        this.grades = grades;
    }
}
