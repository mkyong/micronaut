package com.mkyong;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/")
public class HomeController {

    @Get("/")
    public String defaultPage() {
        return "Welcome to Micronaut!";
    }
}
