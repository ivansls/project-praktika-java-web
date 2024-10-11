package com.web_project.school.service;

import com.web_project.school.model.AuthorModel;
import com.web_project.school.repository.AuthorRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryAuthorServiceImpl implements AuthorService{
    private final AuthorRepository authorRepository;


    public InMemoryAuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorModel> findAllAuthor(){
        return authorRepository.findAll(Sort.by("id"));
    }

    @Override
    public AuthorModel findAuthorById(UUID id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public AuthorModel addAuthor(AuthorModel author){
        return authorRepository.save(author);
    }

    @Override
    public AuthorModel updateAuthor(AuthorModel author){
        if (authorRepository.existsById(author.getId())) {
            return authorRepository.save(author);
        }
        return null;
    }

    @Override
    public void deleteAuthor(UUID id){
        if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
        }
    }

}
