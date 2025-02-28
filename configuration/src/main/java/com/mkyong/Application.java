package com.mkyong;

import com.mkyong.config.AppService;
import io.micronaut.runtime.Micronaut;
import jakarta.inject.Singleton;

@Singleton
public class Application {

    private final AppService appService;

    public Application(AppService appService) {
        this.appService = appService;
    }

    public static void main(String[] args) {
        Micronaut.run(Application.class, args)      // start app
                .getBean(Application.class).init(); // run startup code
    }

    public void init() {
        appService.printConfig();
    }

}