package com.web_project.school.repository;

import com.web_project.school.model.GradesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GradesRepository extends JpaRepository<GradesModel, UUID> {
}
