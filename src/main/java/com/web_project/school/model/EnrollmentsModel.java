package com.web_project.school.model;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "enrollments")
public class EnrollmentsModel{
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CoursesModel course;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private UsersModel student;

    private String enrollmentDate;


    public EnrollmentsModel(CoursesModel course, UsersModel student, String enrollmentDate) {
        this.course = course;
        this.student = student;
        this.enrollmentDate = enrollmentDate;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CoursesModel getCourse() {
        return course;
    }

    public void setCourse(CoursesModel course) {
        this.course = course;
    }

    public UsersModel getStudent() {
        return student;
    }

    public void setStudent(UsersModel student) {
        this.student = student;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}
