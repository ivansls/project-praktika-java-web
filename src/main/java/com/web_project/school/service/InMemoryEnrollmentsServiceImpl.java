package com.web_project.school.service;

import com.web_project.school.model.EnrollmentsModel;
import com.web_project.school.repository.EnrollmentsRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryEnrollmentsServiceImpl implements EnrollmentsService{
    private final EnrollmentsRepository enrollmentsRepository;


    public InMemoryEnrollmentsServiceImpl(EnrollmentsRepository enrollmentsRepository) {
        this.enrollmentsRepository = enrollmentsRepository;
    }


    @Override
    public List<EnrollmentsModel> findAllEnrollments() {
       return enrollmentsRepository.findAll(Sort.by("id"));
    }

    @Override
    public EnrollmentsModel findEnrollmentById(UUID id) {
        return enrollmentsRepository.findById(id).orElse(null);
    }

    @Override
    public EnrollmentsModel addEnrollment(EnrollmentsModel enrollment) {
        return enrollmentsRepository.save(enrollment);
    }

    @Override
    public EnrollmentsModel updateEnrollment(EnrollmentsModel enrollment) {
        if (enrollmentsRepository.existsById(enrollment.getId())) {
            return enrollmentsRepository.save(enrollment);
        }
        return null;
    }

    @Override
    public void deleteEnrollment(UUID id) {
        if (enrollmentsRepository.existsById(id)) {
            enrollmentsRepository.deleteById(id);
        }
    }
}
