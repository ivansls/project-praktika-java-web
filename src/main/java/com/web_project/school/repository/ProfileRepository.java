package com.web_project.school.repository;

import com.individual_project.individual_project.model.ProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfileRepository extends JpaRepository<ProfileModel, UUID> {
}
