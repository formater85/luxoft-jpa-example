package com.luxoft.jpa.domain.service;

import com.luxoft.jpa.domain.model.Book;

import java.util.List;

public interface BookShowcase {

    List<Book> showAll();

    Book findByTitle(String title);

    List<Book> findByAuthorName(String author);
}
