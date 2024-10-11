package com.web_project.school.controllers;

import com.web_project.school.model.StudentModel;
import com.web_project.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/students")
public class StudentApiController {
    @Autowired
    private final StudentService studentService;

    public StudentApiController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentModel> getAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/{id}")
    public StudentModel getStudentById(@PathVariable UUID id){
        return studentService.findStudentById(id);
    }

    @PostMapping
    public StudentModel createStudent(@RequestBody StudentModel student){
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public StudentModel updateStudent(@PathVariable UUID id, @RequestBody StudentModel student){
        student.setId(id);
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable UUID id){
        studentService.deleteStudent(id);
    }
}
