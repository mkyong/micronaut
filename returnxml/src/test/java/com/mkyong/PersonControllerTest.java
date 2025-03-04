package com.mkyong;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class PersonControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testGetPersonReturnsXml() {
        HttpRequest<?> request = HttpRequest.GET("/person")
                .accept("application/xml");

        HttpResponse<String> response = client.toBlocking().exchange(request, String.class);
        
        assertTrue(response.getBody().isPresent());

        String xml = response.getBody().get();
        String expected = "<person id=\"1\"><age>42</age><fullName>Mkyong</fullName></person>";
        assertEquals(expected, xml);
    }
}

