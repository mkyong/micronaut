package com.mkyong.config;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.ConfigurationBuilder;

@ConfigurationProperties("myapp.database")
public class DatabaseConfiguration {

    @ConfigurationBuilder(prefixes = "")
    private final Database.Builder builder = new Database.Builder();

    public Database.Builder getBuilder() {
        return builder;
    }

    public Database build() {
        return builder.build();
    }

}
