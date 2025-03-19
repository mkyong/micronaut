package com.mkyong;

import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class UserRegistrationService {

    private static final Logger LOG = LoggerFactory.getLogger(UserRegistrationService.class);

    public void registerUser(String username) {
        LOG.info("Registering user: {}", username);

        if (username == null || username.isEmpty()) {
            LOG.warn("Attempted to register user with empty username");
            throw new IllegalArgumentException("Username cannot be empty");
        }

        try {
            // logic to register user
            LOG.debug("User {} successfully registered.", username);
        } catch (Exception ex) {
            LOG.error("Error registering user {}", username, ex);
        }
    }

}
