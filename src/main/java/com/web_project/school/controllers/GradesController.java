package com.web_project.school.controllers;


import com.web_project.school.model.GradesModel;
import com.web_project.school.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

@Controller
@RequestMapping("/grades")
@PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER', 'STUDENT')")
public class GradesController {
    @Autowired
    public GradesService gradesService;

    @Autowired
    public UsersService usersService;

    @Autowired
    public AssignmentsService assignmentsService;


    @GetMapping("/all")
    public String getAllEnrollments(Model model) {



        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            if (authentication.getPrincipal() instanceof User userPrincipal) {
                String username = userPrincipal.getUsername();
                String role = userPrincipal.getAuthorities().iterator().next().getAuthority();
                if (role.equals("STUDENT")) {
                    model.addAttribute("grades", gradesService.findAllGrades().stream().filter(grade ->
                            Objects.equals(grade.getStudent().getUsername(), username)).toList());
                }else {
                    model.addAttribute("grades", gradesService.findAllGrades());
                }

            } else {
                System.out.println("Principal is not of type UserModel.");
            }
        } else {
            System.out.println("No authentication found.");
        }

//        if (authentication.getPrincipal() instanceof UsersModel userPrincipal) {
//            username = userPrincipal.getUsername();
//
//        } else {
//            username = "";
//        }
//        model.addAttribute("grades", gradesService.findAllGrades());

        model.addAttribute("grade", new GradesModel());
        model.addAttribute("students", usersService.findAllUsers("STUDENT"));
        model.addAttribute("assignments", assignmentsService.findAllAssignments());
        return "gradeList";
    }

    @PostMapping("/add")
    public String addAllEnrollments(@Valid @ModelAttribute("enrollment") GradesModel grade, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("grades", gradesService.findAllGrades());
            model.addAttribute("students", usersService.findAllUsers("STUDENT"));
            model.addAttribute("assignments", assignmentsService.findAllAssignments());
            return "gradeList";
        }
        if ((grade.getGrade() > 5) && (grade.getGrade() < 1)) {
            model.addAttribute("message", "Ошибка, проверь данные");
            return "gradeList";
        }
        gradesService.addGrade(grade);
        return "redirect:/grades/all";
    }

    @PostMapping("/update")
    public String updateEnrollments(@Valid @ModelAttribute("enrollment") GradesModel grade, BindingResult result) {
        gradesService.updateGrade(grade);
        return "redirect:/grades/all";
    }

    @PostMapping("/delete")
    public String deleteEnrollments(@RequestParam UUID id) {
        gradesService.deleteGrade(id);
        return "redirect:/grades/all";
    }

    @GetMapping("/all/{id}")
    public String getIdEnrollments(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("grades", gradesService.findGradeById(id));
        model.addAttribute("students", usersService.findAllUsers("STUDENT"));
        model.addAttribute("assignments", assignmentsService.findAllAssignments());
        return "gradeList";
    }
}
