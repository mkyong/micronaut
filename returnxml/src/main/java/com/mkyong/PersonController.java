package com.mkyong;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/person")
public class PersonController {

    @Get
    @Produces(MediaType.APPLICATION_XML)
    public Person getPerson() {
        return new Person(1, "Mkyong", 42);
    }
}

