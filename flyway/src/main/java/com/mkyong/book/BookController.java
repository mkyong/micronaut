package com.mkyong.book;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;

import java.util.List;

@Controller("/books")
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @Post
    public HttpResponse<Book> create(@Body Book book) {
        Book saved = repository.save(book);
        return HttpResponse.created(saved);
    }

    @Get
    public List<Book> list() {
        return repository.findAll();
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
