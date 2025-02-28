package com.mkyong;

import com.mkyong.service.DatabaseService;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Inject;

public class Application {

    @Inject
    DatabaseService databaseService;

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

    @EventListener
    public void onStartup(StartupEvent event) {
        System.out.println("Application has started!");
        // Your startup code here, e.g., seeding a database or initializing resources.

        databaseService.printAll();
    }
}