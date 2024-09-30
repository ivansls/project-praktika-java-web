package com.web_project.school.service;

import com.web_project.school.model.PasportModel;
import com.web_project.school.model.StudentModel;

import java.util.List;
import java.util.UUID;

public interface PasportService {
    public List<PasportModel> findAllPasports();

    public PasportModel findPasportById(UUID id);

    public PasportModel addPasport(PasportModel pasport);

    public PasportModel updatePasport(PasportModel pasport);

    public void deletePasport(UUID id);
}
