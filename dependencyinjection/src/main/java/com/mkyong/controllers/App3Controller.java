package com.mkyong.controllers;

import com.mkyong.Services.GreetingService;
import com.mkyong.Services.TimeService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller("/app3")
public class App3Controller {

    // field injection
    @Inject
    private GreetingService greetingService;

    @Inject
    private TimeService timeService;

    @Get("/say")
    public String sayHello() {
        return greetingService.speak("Micronaut") + " at "
                + timeService.getCurrentTime();
    }

}
