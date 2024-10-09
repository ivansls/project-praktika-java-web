package com.web_project.school.repository;

import com.web_project.school.model.ScheduleModule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScheduleRepository extends JpaRepository<ScheduleModule, UUID> {
}
