package com.web_project.school.controllers;


import com.web_project.school.model.CoursesModel;
import com.web_project.school.service.CoursesService;
import com.web_project.school.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/courses")
//@PreCourseize("hasAnyCourseity('TEACHER', 'ADMIN')")
public class CoursesController {
    @Autowired
    public CoursesService coursesService;

    @Autowired
    public UsersService usersService;


    @GetMapping("/all")
    public String getAllCourses(Model model) {
        model.addAttribute("courses", coursesService.findAllCourses());
        model.addAttribute("course", new CoursesModel());
        model.addAttribute("teachers", usersService.findAllUsers());
        return "courseList";
    }

    @PostMapping("/add")
    public String addAllCourses(@Valid @ModelAttribute("course") CoursesModel course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("courses", coursesService.findAllCourses());
            model.addAttribute("teachers", usersService.findAllUsers());
            return "courseList";
        }
        coursesService.addCourse(course);
        return "redirect:/courses/all";
    }

    @PostMapping("/update")
    public String updatCourses(@Valid @ModelAttribute("course") CoursesModel course, BindingResult result) {
        coursesService.updateCourse(course);
        return "redirect:/courses/all";
    }

    @PostMapping("/delete")
    public String deleteCourses(@RequestParam UUID id) {
        coursesService.deleteCourse(id);
        return "redirect:/courses/all";
    }

    @GetMapping("/all/{id}")
    public String getIdCourses(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("courses", coursesService.findCourseById(id));
        model.addAttribute("teachers", usersService.findAllUsers());
        return "courseList";
    }
}
