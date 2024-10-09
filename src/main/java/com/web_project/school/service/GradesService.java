package com.web_project.school.service;

import com.web_project.school.model.GradesModel;

import java.util.List;
import java.util.UUID;

public interface GradesService {
    public List<GradesModel> findAllGrades();

    public GradesModel findGradeById(UUID id);

    public GradesModel addGrade(GradesModel grade);

    public GradesModel updateGrade(GradesModel grade);

    public void deleteGrade(UUID id);
}
