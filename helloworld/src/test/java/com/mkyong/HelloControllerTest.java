package com.mkyong;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
class HelloControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testDefaultPage() {

        HttpRequest<?> request = HttpRequest.GET("/");
        String body = client.toBlocking().retrieve(request);

        assertNotNull(body);
        assertEquals("Welcome to Micronaut!", body);

    }

    @Test
    void testHelloPage() {

        HttpRequest<?> request = HttpRequest.GET("/hello");
        String body = client.toBlocking().retrieve(request);

        assertNotNull(body);
        assertEquals("Hello World", body);

    }

}