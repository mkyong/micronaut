package com.mkyong.controllers;

import com.mkyong.Services.GreetingService;
import com.mkyong.Services.TimeService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Named;

@Controller("/app2")
public class App2Controller {
    private final GreetingService greetingService;

    public App2Controller(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Get("/say")
    public String sayHello() {
        return greetingService.speak("Micronaut");
    }

}
