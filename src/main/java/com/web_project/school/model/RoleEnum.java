package com.web_project.school.model;

import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority {
    STUDENT, TEACHER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
