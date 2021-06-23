package com.luxoft.jpa.config;

import com.luxoft.jpa.domain.model.Author;
import com.luxoft.jpa.domain.model.AuthorRepository;
import com.luxoft.jpa.domain.model.Book;
import com.luxoft.jpa.domain.model.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Set;

@Configuration
@Slf4j
public class H2Configuration {

    @Bean("applicationRunner")
    public ApplicationRunner generateH2Data(AuthorRepository authorRepository, BookRepository bookRepository) {
        return env -> {
            bookRepository.saveAll(generateBooksWithAuthors());
            log.info("You may open the H2 web console here: http://localhost:8080/h2-console");
        };
    }

    private static Set<Book> generateBooksWithAuthors() {
        return Set.of(
                Book.builder()
                        .title("Effective Java 3rd edition")
                        .author(Author.builder()
                                .name("Joshua Bloch")
                                .build())
                        .isbn10("0134685997")
                        .isbn13("978-0134685991")
                        .releaseDate(LocalDate.of(2017, 12, 27))
                        .build(),

                Book.builder()
                        .title("Modern Java in Action")
                        .author(Author.builder()
                                .name("Raoul-Gabriel Urma")
                                .build())
                        .isbn10("1617293563")
                        .isbn13("978-1617293566")
                        .releaseDate(LocalDate.of(2018, 11, 15))
                        .build(),

                Book.builder()
                        .title("Spring in Action 5th edition")
                        .author(Author.builder()
                                .name("Craig Walls")
                                .build())
                        .isbn10("1617294942")
                        .isbn13("978-1617294945")
                        .releaseDate(LocalDate.of(2018, 11, 5))
                        .build(),

                Book.builder()
                        .title("Clean Code: A Handbook of Agile Software Craftsmanship 1st Edition")
                        .author(Author.builder()
                                .name("Robert C. \"Uncle Bob\" Martin")
                                .build())
                        .isbn10("9780132350884")
                        .isbn13("978-0132350884")
                        .releaseDate(LocalDate.of(2008, 8, 1))
                        .build()
        );
    }
}
