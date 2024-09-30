package com.web_project.school.service;

import com.web_project.school.model.PasportModel;
import com.web_project.school.model.UniversityModel;

import java.util.List;
import java.util.UUID;

public interface UniversityService {
    public List<UniversityModel> findAllUniversitys();

    public UniversityModel finduniversityById(UUID id);

    public UniversityModel adduniversity(UniversityModel university);

    public UniversityModel updateuniversity(UniversityModel university);

    public void deleteuniversity(UUID id);
}
