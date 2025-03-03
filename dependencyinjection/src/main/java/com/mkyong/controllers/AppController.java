package com.mkyong.controllers;

import com.mkyong.Services.GreetingService;
import com.mkyong.Services.TimeService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Named;

@Controller("/app")
public class AppController {
    private final GreetingService greetingService;
    private final TimeService timeService;

    public AppController(@Named("Spanish") GreetingService greetingService,
                         TimeService timeService) {
        this.greetingService = greetingService;
        this.timeService = timeService;
    }

    @Get("/say")
    public String sayHello() {
        return greetingService.speak("Micronaut") + " at " + timeService.getCurrentTime();
    }

}
