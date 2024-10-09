package com.web_project.school.model;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "schedule")
public class ScheduleModule {
    @Id
    @GeneratedValue
    private UUID Id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupsModel group;

    private String startTime;
    private String endTime;


    public ScheduleModule(GroupsModel group, String startTime, String endTime) {
        this.group = group;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public GroupsModel getGroup() {
        return group;
    }

    public void setGroup(GroupsModel group) {
        this.group = group;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
