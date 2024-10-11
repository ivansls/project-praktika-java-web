package com.web_project.school.service;

import com.web_project.school.model.BookModel;
import com.web_project.school.repository.BookRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryBookServiceImpl implements BookService{
    private final BookRepository bookRepository;


    public InMemoryBookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookModel> findAllBook(){
        return bookRepository.findAll(Sort.by("Id"));
    }

    @Override
    public BookModel findBookById(UUID id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public BookModel addBook(BookModel book){
        return bookRepository.save(book);
    }

    @Override
    public BookModel updateBook(BookModel book){
        if (bookRepository.existsById(book.getId())) {
            return bookRepository.save(book);
        }
        return null;
    }

    @Override
    public void deleteBook(UUID id){
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        }
    }

}
