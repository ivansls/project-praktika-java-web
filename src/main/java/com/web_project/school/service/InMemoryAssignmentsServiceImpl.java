package com.web_project.school.service;

import com.individual_project.individual_project.model.AssignmentsModel;
import com.individual_project.individual_project.repository.AssignmentsRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryAssignmentsServiceImpl implements AssignmentsService{
    private final AssignmentsRepository assignmentsRepository;


    public InMemoryAssignmentsServiceImpl(AssignmentsRepository assignmentsRepository) {
        this.assignmentsRepository = assignmentsRepository;
    }


    @Override
    public List<AssignmentsModel> findAllAssignments() {
       return assignmentsRepository.findAll(Sort.by("id"));
    }

    @Override
    public AssignmentsModel findAssignmentById(UUID id) {
        return assignmentsRepository.findById(id).orElse(null);
    }

    @Override
    public AssignmentsModel addAssignment(AssignmentsModel assignment) {
        return assignmentsRepository.save(assignment);
    }

    @Override
    public AssignmentsModel updateAssignment(AssignmentsModel assignment) {
        if (assignmentsRepository.existsById(assignment.getId())) {
            return assignmentsRepository.save(assignment);
        }
        return null;
    }

    @Override
    public void deleteAssignment(UUID id) {
        if (assignmentsRepository.existsById(id)) {
            assignmentsRepository.deleteById(id);
        }
    }
}
