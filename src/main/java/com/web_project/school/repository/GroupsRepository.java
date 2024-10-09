package com.web_project.school.repository;

import com.individual_project.individual_project.model.GroupsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GroupsRepository extends JpaRepository<GroupsModel, UUID> {
}
