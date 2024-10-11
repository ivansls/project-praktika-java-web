package com.web_project.school.repository;

import com.web_project.school.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersRepository extends JpaRepository<UsersModel, UUID> {
}
