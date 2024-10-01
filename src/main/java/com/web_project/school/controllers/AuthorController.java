package com.web_project.school.controllers;

import com.web_project.school.model.AuthorModel;
import com.web_project.school.model.UniversityModel;
import com.web_project.school.service.AuthorService;
import com.web_project.school.service.UniversityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    public AuthorService authorService;


    @GetMapping("/all")
    public String getAllAuthors(Model model) {
        model.addAttribute("authors", authorService.findAllAuthor());
        model.addAttribute("author", new AuthorModel());
        return "authorList";
    }

    @PostMapping("/add")
    public String addAllAuthors(@Valid @ModelAttribute("author") AuthorModel author, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("authors", authorService.findAllAuthor());
            return "authorList";
        }
        authorService.addAuthor(author);
        return "redirect:/authors/all";
    }

    @PostMapping("/update")
    public String updatAuthors(@Valid @ModelAttribute("author") AuthorModel author, BindingResult result) {
        authorService.updateAuthor(author);
        return "redirect:/authors/all";
    }

    @PostMapping("/delete")
    public String deleteAuthors(@RequestParam UUID id) {
        authorService.deleteAuthor(id);
        return "redirect:/authors/all";
    }

    @GetMapping("/all/{id}")
    public String getIdAuthors(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("authors", authorService.findAuthorById(id));
        model.addAttribute("author", new UniversityModel());
        return "authorList";
    }


}
