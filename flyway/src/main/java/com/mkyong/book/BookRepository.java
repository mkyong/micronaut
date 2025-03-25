package com.mkyong.book;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

// @Repository
@JdbcRepository(dialect = Dialect.POSTGRES)
public interface BookRepository extends CrudRepository<Book, Long> {
}