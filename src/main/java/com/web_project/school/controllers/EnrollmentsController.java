package com.web_project.school.controllers;


import com.web_project.school.model.EnrollmentsModel;
import com.web_project.school.service.CoursesService;
import com.web_project.school.service.EnrollmentsService;
import com.web_project.school.service.UsersService;
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
@RequestMapping("/enrollments")
@PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER', 'STUDENT')")
public class EnrollmentsController {
    @Autowired
    public EnrollmentsService enrollmentsService;

    @Autowired
    public UsersService usersService;

    @Autowired
    public CoursesService coursesService;


    @GetMapping("/all")
    public String getAllEnrollments(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            if (authentication.getPrincipal() instanceof User userPrincipal) {
                String username = userPrincipal.getUsername();
                String role = userPrincipal.getAuthorities().iterator().next().getAuthority();
                if (role.equals("STUDENT")) {
                    model.addAttribute("enrollments", enrollmentsService.findAllEnrollments().stream().filter(grade ->
                            Objects.equals(grade.getStudent().getUsername(), username)).toList());
                }else {
                    model.addAttribute("enrollments", enrollmentsService.findAllEnrollments());
                }

            } else {
                System.out.println("Principal is not of type UserModel.");
            }
        } else {
            System.out.println("No authentication found.");
        }
        //model.addAttribute("enrollments", enrollmentsService.findAllEnrollments());
        model.addAttribute("enrollment", new EnrollmentsModel());
        model.addAttribute("students", usersService.findAllUsers("STUDENT"));
        model.addAttribute("courses", coursesService.findAllCourses());
        return "enrollmentList";
    }

    @PostMapping("/add")
    public String addAllEnrollments(@Valid @ModelAttribute("enrollment") EnrollmentsModel enrollment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("enrollments", enrollmentsService.findAllEnrollments());
            model.addAttribute("students", usersService.findAllUsers("STUDENT"));
            model.addAttribute("courses", coursesService.findAllCourses());
            return "enrollmentList";
        }
        enrollmentsService.addEnrollment(enrollment);
        return "redirect:/enrollments/all";
    }

    @PostMapping("/update")
    public String updateEnrollments(@Valid @ModelAttribute("enrollment") EnrollmentsModel enrollment, BindingResult result) {
        enrollmentsService.updateEnrollment(enrollment);
        return "redirect:/enrollments/all";
    }

    @PostMapping("/delete")
    public String deleteEnrollments(@RequestParam UUID id) {
        enrollmentsService.deleteEnrollment(id);
        return "redirect:/enrollments/all";
    }

    @GetMapping("/all/{id}")
    public String getIdEnrollments(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("enrollments", enrollmentsService.findEnrollmentById(id));
        model.addAttribute("students", usersService.findAllUsers("STUDENT"));
        model.addAttribute("courses", coursesService.findAllCourses());
        return "enrollmentList";
    }
}
