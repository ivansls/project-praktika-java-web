package com.web_project.school.controllers;

import com.web_project.school.model.PasportModel;
import com.web_project.school.model.UniversityModel;
import com.web_project.school.service.UniversityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/students")
public class UniversityController {
    @Autowired
    public UniversityService universityService;

    @GetMapping("/all")
    public String getAllStudents(Model model) {
        model.addAttribute("universityes", universityService.findAllUniversitys());
        model.addAttribute("university", new UniversityModel());
        return "studentList";
    }

    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("student") UniversityModel student, BindingResult result, Model model) {
        if (result.hasErrors()){
            model.addAttribute("universityes", universityService.findAllUniversitys());
            return "studentList";
        }
        universityService.adduniversity(student);
        return "redirect:/students/all";
    }

    @PostMapping("/update")
    public String updateStudent(@Valid @ModelAttribute("student") UniversityModel student, BindingResult result) {
        universityService.updateuniversity(student);
        return "redirect:/students/all";
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam UUID id) {
        universityService.deleteuniversity(id);
        return "redirect:/students/all";
    }

    @GetMapping("/all/{id}")
    public String getIdStudent(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("universityes", universityService.finduniversityById(id));
        model.addAttribute("university", new UniversityModel());
        return "studentList";
    }


}
