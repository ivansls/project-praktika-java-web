package com.web_project.school.repository;

import com.web_project.school.model.PasportModel;
import com.web_project.school.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PasportRepository extends JpaRepository<PasportModel, UUID> {

}
