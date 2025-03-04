package com.mkyong;

import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class DatabaseService {

    private static final Logger LOG = LoggerFactory.getLogger(DatabaseService.class);

    @EventListener
    void init(StartupEvent event) {
        LOG.info("Database init has started!");
    }
}
