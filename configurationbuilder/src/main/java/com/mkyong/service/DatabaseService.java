package com.mkyong.service;

import com.mkyong.config.Database;
import com.mkyong.config.DatabaseConfiguration;
import jakarta.inject.Singleton;

@Singleton
public class DatabaseService {
    private final Database database;

    public DatabaseService(DatabaseConfiguration configuration) {
        this.database = configuration.build();
    }

    public void printAll() {
        System.out.println("Database URL: " + database.getUrl());
        System.out.println("Username: " + database.getUsername());
        System.out.println("Password: " + database.getPassword());
        System.out.println("Max Pool Size: " + database.getMaxSize());
        System.out.println("Min Pool Size: " + database.getMinSize());
    }
}
