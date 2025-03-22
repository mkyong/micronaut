package com.mkyong;

import jakarta.inject.Singleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Singleton
public class LoggingService {

    private static final Logger logger = LogManager.getLogger(LoggingService.class);

    public void logSomething() {
        logger.info("This is an INFO log.");
        logger.warn("This is a WARN log.");
        logger.error("This is an ERROR log.");
    }

}

