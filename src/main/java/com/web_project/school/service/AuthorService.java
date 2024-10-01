package com.web_project.school.service;

import com.web_project.school.model.AuthorModel;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    public List<AuthorModel> findAllAuthor();

    public AuthorModel findAuthorById(UUID id);

    public AuthorModel addAuthor(AuthorModel author);

    public AuthorModel updateAuthor(AuthorModel author);

    public void deleteAuthor(UUID id);
}
