package com.web_project.school.repository;

import com.individual_project.individual_project.model.EnrollmentsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnrollmentsRepository extends JpaRepository<EnrollmentsModel, UUID> {
}
