package com.web_project.school.service;

import com.web_project.school.model.CoursesModel;
import com.web_project.school.repository.CoursesRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryCoursesServiceImpl implements CoursesService{
    private final CoursesRepository coursesRepository;


    public InMemoryCoursesServiceImpl(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }


    @Override
    public List<CoursesModel> findAllCourses() {
       return coursesRepository.findAll(Sort.by("id"));
    }

    @Override
    public CoursesModel findCourseById(UUID id) {
        return coursesRepository.findById(id).orElse(null);
    }

    @Override
    public CoursesModel addCourse(CoursesModel course) {
        return coursesRepository.save(course);
    }

    @Override
    public CoursesModel updateCourse(CoursesModel course) {
        if (coursesRepository.existsById(course.getId())) {
            return coursesRepository.save(course);
        }
        return null;
    }

    @Override
    public void deleteCourse(UUID id) {
        if (coursesRepository.existsById(id)) {
            coursesRepository.deleteById(id);
        }
    }
}
