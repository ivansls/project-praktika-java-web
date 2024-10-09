package com.web_project.school.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "groups")
public class GroupsModel {
    @Id
    @GeneratedValue
    private UUID id;
    @Size(min = 3, message = "Имя не менее 3 символов")
    private String name;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CoursesModel course;

    @OneToMany(mappedBy = "group")
    private List<ScheduleModule> schedules;

    public GroupsModel(String name, CoursesModel course, List<ScheduleModule> schedules) {
        this.name = name;
        this.course = course;
        this.schedules = schedules;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @Size(min = 3, message = "Имя не менее 3 символов") String getName() {
        return name;
    }

    public void setName(@Size(min = 3, message = "Имя не менее 3 символов") String name) {
        this.name = name;
    }

    public CoursesModel getCourse() {
        return course;
    }

    public void setCourse(CoursesModel course) {
        this.course = course;
    }

    public List<ScheduleModule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ScheduleModule> schedules) {
        this.schedules = schedules;
    }
}
