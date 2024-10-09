package com.web_project.school.service;

import com.individual_project.individual_project.model.CoursesModel;

import java.util.List;
import java.util.UUID;

public interface CoursesService {
    public List<CoursesModel> findAllCourses();

    public CoursesModel findCourseById(UUID id);

    public CoursesModel addCourse(CoursesModel courses);

    public CoursesModel updateCourse(CoursesModel courses);

    public void deleteCourse(UUID id);
}
