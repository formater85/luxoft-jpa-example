package com.luxoft.jpa.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The IntelliJ can show a notification that it cannot resolve table AUTHORS or any column.
 * It because the used H2 database exists only in memory when the application is running.
 *
 * @see Book
 * @link [JSR 338, Ch 2.1] https://download.oracle.com/otndocs/jcp/persistence-2_1-fr-eval-spec/index.html
 */
@Entity
@Table(name = "authors")
// Generates a builder for the Book class.
@Builder
// Generates getters and setters for all fields.
@Getter
@Setter
// Generates the no-arg and all-arg constructors with protected access modifier.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String name;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    @Singular
    private Set<Book> books = new HashSet<>();
}
