package com.web_project.school.controllers;

import com.web_project.school.model.UniversityModel;
import com.web_project.school.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/universities")
public class UniversityApiController {
    @Autowired
    private final UniversityService universityService;

    public UniversityApiController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public List<UniversityModel> getAllUniversities() {
        return universityService.findAllUniversities();
    }

    @GetMapping("/{id}")
    public UniversityModel getUniversityById(@PathVariable UUID id){
        return universityService.findUniversityById(id);
    }

    @PostMapping
    public UniversityModel createUniversity(@RequestBody UniversityModel university){
        return universityService.addUniversity(university);
    }

    @PutMapping("/{id}")
    public UniversityModel updateUniversity(@PathVariable UUID id, @RequestBody UniversityModel university){
        university.setId(id);
        return universityService.updateUniversity(university);
    }

    @DeleteMapping("/{id}")
    public void deleteUniversity(@PathVariable UUID id){
        universityService.deleteUniversity(id);
    }
}
