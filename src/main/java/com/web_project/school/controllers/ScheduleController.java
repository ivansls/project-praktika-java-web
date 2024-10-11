package com.web_project.school.controllers;


import com.web_project.school.model.ScheduleModule;
import com.web_project.school.service.GroupsService;
import com.web_project.school.service.ScheduleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/schedules")
@PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER', 'STUDENT')")
public class ScheduleController {
    @Autowired
    public ScheduleService ScheduleService;

    @Autowired
    public GroupsService groupsService;


    @GetMapping("/all")
    public String getAllSchedule(Model model) {
        model.addAttribute("schedules", ScheduleService.findAllSchedule());
        model.addAttribute("schedule", new ScheduleModule());
        model.addAttribute("groups", groupsService.findAllGroups());
        return "scheduleList";
    }

    @PostMapping("/add")
    public String addAllSchedule(@Valid @ModelAttribute("schedule") ScheduleModule schedule, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("schedules", ScheduleService.findAllSchedule());
            model.addAttribute("groups", groupsService.findAllGroups());
            return "scheduleList";
        }
        ScheduleService.addSchedule(schedule);
        return "redirect:/schedules/all";
    }

    @PostMapping("/update")
    public String updatSchedule(@Valid @ModelAttribute("schedule") ScheduleModule schedule, BindingResult result) {
        ScheduleService.updateSchedule(schedule);
        return "redirect:/schedules/all";
    }

    @PostMapping("/delete")
    public String deleteSchedule(@RequestParam UUID id) {
        ScheduleService.deleteSchedule(id);
        return "redirect:/schedules/all";
    }

    @GetMapping("/all/{id}")
    public String getIdSchedule(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("schedules", ScheduleService.findScheduleById(id));
        model.addAttribute("groups", groupsService.findAllGroups());
        return "scheduleList";
    }
}
