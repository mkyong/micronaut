package com.mkyong;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class StartupListener implements ApplicationEventListener<ServerStartupEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(StartupListener.class);

    @Override
    public void onApplicationEvent(ServerStartupEvent event) {

        LOG.info("Micronaut application has started!");
        runStartupTasks();

    }

    private void runStartupTasks() {
        LOG.info("Performing startup tasks such as initializing resources.");
    }

}
