package com.mkyong.controllers;

import com.mkyong.Services.GreetingService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller("/app4")
public class App4Controller {

    private GreetingService greetingService;

    // method injection
    @Inject
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Get("/say")
    public String sayHello() {
        return greetingService.speak("Micronaut");
    }

}
