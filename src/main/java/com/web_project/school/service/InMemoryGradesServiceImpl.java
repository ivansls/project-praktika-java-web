package com.web_project.school.service;

import com.web_project.school.model.GradesModel;
import com.web_project.school.repository.GradesRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryGradesServiceImpl implements GradesService{
    private final GradesRepository gradesRepository;


    public InMemoryGradesServiceImpl(GradesRepository gradesRepository) {
        this.gradesRepository = gradesRepository;
    }


    @Override
    public List<GradesModel> findAllGrades() {
       return gradesRepository.findAll(Sort.by("id"));
    }

    @Override
    public GradesModel findGradeById(UUID id) {
        return gradesRepository.findById(id).orElse(null);
    }

    @Override
    public GradesModel addGrade(GradesModel grade) {
        return gradesRepository.save(grade);
    }

    @Override
    public GradesModel updateGrade(GradesModel grade) {
        if (gradesRepository.existsById(grade.getId())) {
            return gradesRepository.save(grade);
        }
        return null;
    }

    @Override
    public void deleteGrade(UUID id) {
        if (gradesRepository.existsById(id)) {
            gradesRepository.deleteById(id);
        }
    }
}
