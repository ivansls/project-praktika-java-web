package com.web_project.school.repository;

import com.web_project.school.model.MusicModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<MusicModel, Long> {
}
