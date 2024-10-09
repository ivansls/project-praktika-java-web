package com.web_project.school.service;

import com.individual_project.individual_project.model.AssignmentsModel;

import java.util.List;
import java.util.UUID;

public interface AssignmentsService {

    public List<AssignmentsModel> findAllAssignments();

    public AssignmentsModel findAssignmentById(UUID id);

    public AssignmentsModel addAssignment(AssignmentsModel assignment);

    public AssignmentsModel updateAssignment(AssignmentsModel assignment);

    public void deleteAssignment(UUID id);
}
