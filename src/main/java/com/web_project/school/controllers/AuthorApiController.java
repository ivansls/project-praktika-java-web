package com.web_project.school.controllers;

import com.web_project.school.model.AuthorModel;
import com.web_project.school.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/authors")
public class AuthorApiController {
    @Autowired
    private final AuthorService authorService;

    public AuthorApiController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorModel> deleteAuthor() {
        return authorService.findAllAuthor();
    }

    @GetMapping("/{id}")
    public AuthorModel getAuthorById(@PathVariable UUID id){
        return authorService.findAuthorById(id);
    }

    @PostMapping
    public AuthorModel createAuthor(@RequestBody AuthorModel author){
        return authorService.addAuthor(author);
    }

    @PutMapping("/{id}")
    public AuthorModel updateAuthor(@PathVariable UUID id, @RequestBody AuthorModel author){
        author.setId(id);
        return authorService.updateAuthor(author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable UUID id){
        authorService.deleteAuthor(id);
    }
}
