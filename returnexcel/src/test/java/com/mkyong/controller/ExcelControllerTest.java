package com.mkyong.controller;

import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class ExcelControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testExcelDownload() {
        var response = client.toBlocking().exchange("/excel/download", byte[].class);

        assertEquals(HttpStatus.OK, response.status());
        assertTrue(response.getHeaders().get(HttpHeaders.CONTENT_DISPOSITION).contains("employees.xlsx"));
        assertNotNull(response.body());
    }
}
