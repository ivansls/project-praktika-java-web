package com.web_project.school.controllers;

import com.web_project.school.model.BookModel;
import com.web_project.school.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/books")
public class BookApiController {
    @Autowired
    private final BookService bookService;

    public BookApiController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookModel> getAllBooks() {
        return bookService.findAllBook();
    }

    @GetMapping("/{id}")
    public BookModel getBookById(@PathVariable UUID id){
        return bookService.findBookById(id);
    }

    @PostMapping
    public BookModel createBook(@RequestBody BookModel books){
        return bookService.addBook(books);
    }

    @PutMapping("/{id}")
    public BookModel updateBook(@PathVariable UUID id, @RequestBody BookModel books){
        books.setId(id);
        return bookService.updateBook(books);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable UUID id){
        bookService.deleteBook(id);
    }
}
