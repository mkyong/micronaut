package com.mkyong.controller;

import com.mkyong.model.User;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;

@Controller("/users")
public class UserController {

    @Get(produces = MediaType.APPLICATION_JSON)
    public User getUser() {
        return new User("Mkyong", 42);
    }

    @Get(uri = "/all", produces = MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return List.of(
                new User("Mkyong", 42),
                new User("Zi Lap", 10)
        );
    }

}
