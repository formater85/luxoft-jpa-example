package com.luxoft.jpa.domain.service;

import com.luxoft.jpa.domain.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This test uses predefined data.
 *
 * @see com.luxoft.jpa.config.H2Configuration
 */
@SpringBootTest
class PrimaryBookShowcaseTest {

    @Autowired
    PrimaryBookShowcase bookShowcase;

    @Test
    void findBookByAuthorLike_Success() {
        List<Book> books = bookShowcase.findByAuthorName("Joshua Bloch");

        assertNotNull(books, "Returned collection should not be null");
        assertTrue(books.size() > 0, "Returned collection should contain one item at least");
        assertEquals("Effective Java 3rd edition", books.get(0).getTitle());
    }

}