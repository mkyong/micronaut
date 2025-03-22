package com.mkyong;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/log")
public class LoggingController {

    private final LoggingService service;

    public LoggingController(LoggingService service) {
        this.service = service;
    }

    @Get("/")
    public String triggerLogging() {
        service.logSomething();
        return "Logging triggered. Check console and log files.";
    }

}

