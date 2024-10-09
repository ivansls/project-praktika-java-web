package com.web_project.school.service;

import com.web_project.school.model.EnrollmentsModel;

import java.util.List;
import java.util.UUID;

public interface EnrollmentsService {
    public List<EnrollmentsModel> findAllEnrollments();

    public EnrollmentsModel findEnrollmentById(UUID id);

    public EnrollmentsModel addEnrollment(EnrollmentsModel enrollment);

    public EnrollmentsModel updateEnrollment(EnrollmentsModel enrollment);

    public void deleteEnrollment(UUID id);
}
