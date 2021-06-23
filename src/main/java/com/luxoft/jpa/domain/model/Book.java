package com.luxoft.jpa.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * The IntelliJ can show a notification that it cannot resolve table BOOKS or any column.
 * It because the used H2 database exists only in memory when the application is running.
 *
 * @see Author
 * @link [JSR 338, Ch 2.1] https://download.oracle.com/otndocs/jcp/persistence-2_1-fr-eval-spec/index.html
 */
@Entity
@Table(name = "books")
// Generates a builder for the Book class.
@Builder
// Generates getters and setters for all fields.
@Getter
@Setter
// Generates the no-arg and all-arg constructors with protected access modifier.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "ISBN_10")
    private String isbn10;

    @Column(name = "ISBN_13")
    private String isbn13;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "books_authors_rel",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    @Singular
    private Set<Author> authors = new HashSet<>();
}
