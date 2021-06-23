package com.luxoft.jpa.domain.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByTitle(String title);
    List<Book> findByAuthors_name(String name);
}
