package com.mkyong;

import com.mkyong.book.Book;
import com.mkyong.book.BookRepository;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.micronaut.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
class BookControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    //@Inject
    //BookRepository bookRepository;

    @Test
    void testCreateAndListBooks() {
        Book book = new Book();
        book.setTitle("Effective Java");
        book.setAuthor("Joshua Bloch");
        book.setPublishedYear(2018);

        Book saved = client.toBlocking().retrieve(
                HttpRequest.POST("/books", book),
                Book.class);

        assertNotNull(saved.getId());
        assertEquals("Effective Java", saved.getTitle());
        assertEquals(2018, saved.getPublishedYear());

        // cleanup
        HttpResponse<Book> response = client.toBlocking().exchange(
                HttpRequest.DELETE("/books/" + saved.getId()));

        assertEquals(HttpStatus.NO_CONTENT, response.getStatus());

    }
}
