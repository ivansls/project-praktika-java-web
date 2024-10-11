package com.web_project.school.service;

import com.web_project.school.model.BookModel;

import java.util.List;
import java.util.UUID;

public interface BookService {
    public List<BookModel> findAllBook();

    public BookModel findBookById(UUID id);

    public BookModel addBook(BookModel book);

    public BookModel updateBook(BookModel book);

    public void deleteBook(UUID id);
}
