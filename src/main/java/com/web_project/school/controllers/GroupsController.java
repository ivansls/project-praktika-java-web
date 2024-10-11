package com.web_project.school.controllers;


import com.web_project.school.model.GroupsModel;
import com.web_project.school.service.CoursesService;
import com.web_project.school.service.GroupsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/groups")
@PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER', 'STUDENT')")
public class GroupsController {
    @Autowired
    public GroupsService groupsService;

    @Autowired
    public CoursesService coursesService;




    @GetMapping("/all")
    public String getAllEnrollments(Model model) {
        model.addAttribute("groups", groupsService.findAllGroups());
        model.addAttribute("group", new GroupsModel());
        model.addAttribute("courses", coursesService.findAllCourses());
        return "groupList";
    }

    @PostMapping("/add")
    public String addAllEnrollments(@Valid @ModelAttribute("enrollment") GroupsModel group, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("groups", groupsService.findAllGroups());
            model.addAttribute("courses", coursesService.findAllCourses());
            return "groupList";
        }
        groupsService.addGroup(group);
        return "redirect:/groups/all";
    }

    @PostMapping("/update")
    public String updateEnrollments(@Valid @ModelAttribute("enrollment") GroupsModel group, BindingResult result) {
        groupsService.updateGroup(group);
        return "redirect:/groups/all";
    }

    @PostMapping("/delete")
    public String deleteEnrollments(@RequestParam UUID id) {
        groupsService.deleteGroup(id);
        return "redirect:/groups/all";
    }

    @GetMapping("/all/{id}")
    public String getIdEnrollments(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("groups", groupsService.findGroupById(id));
        model.addAttribute("courses", coursesService.findAllCourses());
        return "groupList";
    }
}
