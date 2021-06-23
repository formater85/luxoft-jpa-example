package com.luxoft.jpa.domain.service;

import com.luxoft.jpa.domain.model.Book;
import com.luxoft.jpa.domain.model.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrimaryBookShowcase implements BookShowcase {

    private BookRepository bookRepository;

    @Autowired
    public PrimaryBookShowcase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> showAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> findByAuthorName(String authorName) {
        return bookRepository.findByAuthors_name(authorName);
    }
}
