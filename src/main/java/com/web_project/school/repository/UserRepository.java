package com.web_project.school.repository;

import com.web_project.school.model.UserModel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UserModel, UUID> {
    UserModel findByUsername(String username);
    boolean existsByUsername(String username);
}
