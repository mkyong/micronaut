package com.mkyong;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class ZipControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testDownloadZip() throws IOException {
        byte[] response = client.toBlocking()
                .retrieve(HttpRequest.GET("/zip/download"), byte[].class);

        assertNotNull(response);
        assertTrue(response.length > 0);

        // Validate ZIP content
        try (ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(response))) {
            ZipEntry entry;
            int fileCount = 0;

            while ((entry = zis.getNextEntry()) != null) {
                assertNotNull(entry);
                assertTrue(entry.getName().matches("file1.txt|file2.txt|application.properties"));
                zis.closeEntry();
                fileCount++;
            }
            assertEquals(3, fileCount);
        } catch (IOException e) {
            fail("IOException occurred during ZIP validation: " + e.getMessage());
        }
    }
}
