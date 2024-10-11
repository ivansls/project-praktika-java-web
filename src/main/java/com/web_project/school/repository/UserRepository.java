package com.web_project.school.repository;

import com.web_project.school.model.UsersModel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UsersModel, UUID> {
    UsersModel findByUsername(String username);
    boolean existsByUsername(String username);
}
