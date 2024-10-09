package com.web_project.school.repository;

import com.individual_project.individual_project.model.CoursesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoursesRepository extends JpaRepository<CoursesModel, UUID> {
}
