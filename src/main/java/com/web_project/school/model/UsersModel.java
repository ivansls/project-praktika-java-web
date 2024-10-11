package com.web_project.school.model;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UsersModel {
    @Id
    @GeneratedValue
    private UUID id;
    private String username;
    @Nullable
    @Pattern(regexp = "([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9_-]+)",
            message = "Емеил не корректен")
    private String email;
    @Size(min = 8, message = "Пароль должен содержать не менее 8 символов")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!])(?=\\S+$).*$",
            message = "Пароль должен содержать хотя бы одну букву, одну цифру и один специальный символ (@#$%^&+=!)")
    private String password;
    private boolean active;
    @ElementCollection(targetClass = RoleEnum.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<RoleEnum> roles;




    @ManyToMany
    @JoinTable(
            name = "enrollments",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<CoursesModel> courses;


    @Nullable
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private ProfileModel profile;

    public UsersModel() {}

    public UsersModel(String username, String email, String password, boolean active, Set<RoleEnum> roles, List<CoursesModel> courses, ProfileModel profile) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.active = active;
        this.roles = roles;
        this.courses = courses;
        this.profile = profile;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEnum> roles) {
        this.roles = roles;
    }

    public List<CoursesModel> getCourses() {
        return courses;
    }

    public void setCourses(List<CoursesModel> courses) {
        this.courses = courses;
    }

    public ProfileModel getProfile() {
        return profile;
    }

    public void setProfile(ProfileModel profile) {
        this.profile = profile;
    }
}
