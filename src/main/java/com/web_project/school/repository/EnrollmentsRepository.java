package com.web_project.school.repository;

import com.web_project.school.model.EnrollmentsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnrollmentsRepository extends JpaRepository<EnrollmentsModel, UUID> {
}
