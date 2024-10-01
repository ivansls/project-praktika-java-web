package com.web_project.school.repository;

import com.web_project.school.model.LocationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocationRepository extends JpaRepository<LocationModel, UUID> {
}
