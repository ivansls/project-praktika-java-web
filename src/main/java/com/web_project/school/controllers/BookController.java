package com.web_project.school.controllers;

import com.web_project.school.model.AuthorModel;
import com.web_project.school.model.BookModel;
import com.web_project.school.model.LocationModel;
import com.web_project.school.service.AuthorService;
import com.web_project.school.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    public BookService bookService;

    @Autowired
    public AuthorService authorService;

    @GetMapping("/all")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.findAllBook());
        model.addAttribute("book", new BookModel());
        model.addAttribute("authors", authorService.findAllAuthor());
        return "bookList";
    }

    @PostMapping("/add")
    public String addBooks(@Valid @ModelAttribute("book") BookModel book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("books", bookService.findAllBook());
            model.addAttribute("authors", authorService.findAllAuthor());
            return "bookList";
        }
//        AuthorModel author = book.getAuthors();
//        book.setAuthors(author);

        LocationModel location = book.getLocation();
        book.setLocation(location);
        bookService.addBook(book);
        return "redirect:/books/all";
    }

    @PostMapping("/update")
    public String updateBooks(@Valid @ModelAttribute("book") BookModel book, BindingResult result) {
        bookService.updateBook(book);
        return "redirect:/books/all";
    }

    @PostMapping("/delete")
    public String deleteBooks(@RequestParam UUID id) {
        bookService.deleteBook(id);
        return "redirect:/books/all";
    }

    @GetMapping("/all/{id}")
    public String getIdBooks(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("books", bookService.findBookById(id));
        model.addAttribute("book", new BookModel());
        model.addAttribute("authors", authorService.findAllAuthor());
        return "bookList";
    }


}
