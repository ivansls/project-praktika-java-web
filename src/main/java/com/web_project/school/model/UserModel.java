package com.web_project.school.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class UserModel {
    @Id
    @GeneratedValue
    private Long idUser;
    private String username;
    private String password;
    private String role;
    private boolean active;

    @ElementCollection(targetClass = RoleEnum.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<RoleEnum> roles;

    public UserModel() {}

    public UserModel(Long idUser, String username, String password, String role, boolean active, Set<RoleEnum> roles) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.role = role;
        this.active = active;
        this.roles = roles;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
}
