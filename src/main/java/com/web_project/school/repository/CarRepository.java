package com.web_project.school.repository;

import com.web_project.school.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarModel, Long> {


}
