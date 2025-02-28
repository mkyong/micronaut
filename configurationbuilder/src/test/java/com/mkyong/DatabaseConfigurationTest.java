package com.mkyong;

import com.mkyong.config.Database;
import com.mkyong.config.DatabaseConfiguration;
import io.micronaut.context.ApplicationContext;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseConfigurationTest {
    @Test
    void testDatabaseConfiguration() {
        try (ApplicationContext context = ApplicationContext.run(
                "myapp.database.url", "jdbc:mysql://localhost:3306/mydb",
                "myapp.database.username", "root",
                "myapp.database.password", "secret",
                "myapp.database.pool.max-size", "10",
                "myapp.database.pool.min-size", "1")) {

            DatabaseConfiguration config = context.getBean(DatabaseConfiguration.class);
            Database database = config.build();

            assertEquals("jdbc:mysql://localhost:3306/mydb", database.getUrl());
            assertEquals("root", database.getUsername());
            assertEquals("secret", database.getPassword());
            assertEquals(10, database.getMaxSize());
            assertEquals(1, database.getMinSize());
        }
    }
}
