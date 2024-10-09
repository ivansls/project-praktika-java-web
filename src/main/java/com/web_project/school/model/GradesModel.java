package com.web_project.school.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

import java.util.UUID;

@Entity
@Table(name = "grades")
public class GradesModel {
    @Id
    @GeneratedValue
    private UUID Id;

    @Range(min = 1, max = 5)
    private int grade;

    @Size(max = 20)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private AssignmentsModel assignment;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private UsersModel student;


    public GradesModel(int grade, String comment, AssignmentsModel assignment, UsersModel student) {
        this.grade = grade;
        this.comment = comment;
        this.assignment = assignment;
        this.student = student;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    @Range(min = 1, max = 5)
    public int getGrade() {
        return grade;
    }

    public void setGrade(@Range(min = 1, max = 5) int grade) {
        this.grade = grade;
    }

    public @Size(max = 20) String getComment() {
        return comment;
    }

    public void setComment(@Size(max = 20) String comment) {
        this.comment = comment;
    }

    public AssignmentsModel getAssignment() {
        return assignment;
    }

    public void setAssignment(AssignmentsModel assignment) {
        this.assignment = assignment;
    }

    public UsersModel getStudent() {
        return student;
    }

    public void setStudent(UsersModel student) {
        this.student = student;
    }
}
