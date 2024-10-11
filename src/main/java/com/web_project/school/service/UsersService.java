package com.web_project.school.service;

import com.web_project.school.model.UsersModel;

import java.util.List;
import java.util.UUID;

public interface UsersService {
    public List<UsersModel> findAllUsers(String role);

    public UsersModel findUserById(UUID id);

    public UsersModel addUser(UsersModel group);

    public UsersModel updateUser(UsersModel group);

    public void deleteUser(UUID id);
}
