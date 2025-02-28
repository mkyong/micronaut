package com.mkyong;

import com.mkyong.config.AppConfig;
import com.mkyong.config.AppService;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class AppServiceTest {

    @Inject
    AppService appService;

    @Inject
    AppConfig appConfig;

    @Test
    void testAppConfigProperties() {
        assertEquals("MicronautApp", appConfig.getName());
        assertEquals(1, appConfig.getVersion());

        List<String> supportedLanguages = appConfig.getSupportedLanguages();
        assertNotNull(supportedLanguages);
        assertEquals(3, supportedLanguages.size());
        assertTrue(supportedLanguages.contains("English"));
        assertTrue(supportedLanguages.contains("Spanish"));
        assertTrue(supportedLanguages.contains("French"));

        Map<String, String> metadata = appConfig.getMetadata();
        assertNotNull(metadata);
        assertEquals(2, metadata.size());
        assertEquals("mkyong", metadata.get("author"));
        assertEquals("MIT", metadata.get("license"));
    }
}
