package com.web_project.school.controllers;


import com.web_project.school.model.AssignmentsModel;
import com.web_project.school.service.AssignmentsService;
import com.web_project.school.service.CoursesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/assignments")
//@PreAssignmentize("hasAnyAssignmentity('TEACHER', 'ADMIN')")
public class AssignmentsController {
    @Autowired
    public AssignmentsService assignmentsService;

    @Autowired
    public CoursesService coursesService;


    @GetMapping("/all")
    public String getAllAssignments(Model model) {
        model.addAttribute("assignments", assignmentsService.findAllAssignments());
        model.addAttribute("assignment", new AssignmentsModel());
        model.addAttribute("courses", coursesService.findAllCourses());
        return "assignmentList";
    }

    @PostMapping("/add")
    public String addAllAssignments(@Valid @ModelAttribute("assignment") AssignmentsModel assignment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("assignments", assignmentsService.findAllAssignments());
            model.addAttribute("courses", coursesService.findAllCourses());
            return "assignmentList";
        }
        assignmentsService.addAssignment(assignment);
        return "redirect:/assignments/all";
    }

    @PostMapping("/update")
    public String updatAssignments(@Valid @ModelAttribute("assignment") AssignmentsModel assignment, BindingResult result) {
        assignmentsService.updateAssignment(assignment);
        return "redirect:/assignments/all";
    }

    @PostMapping("/delete")
    public String deleteAssignments(@RequestParam UUID id) {
        assignmentsService.deleteAssignment(id);
        return "redirect:/assignments/all";
    }

    @GetMapping("/all/{id}")
    public String getIdAssignments(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("assignments", assignmentsService.findAssignmentById(id));
        model.addAttribute("courses", coursesService.findAllCourses());
        return "assignmentList";
    }
}
