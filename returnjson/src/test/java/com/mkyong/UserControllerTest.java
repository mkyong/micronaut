package com.mkyong;

import com.mkyong.model.User;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
public class UserControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testGetUser() {
        HttpRequest<String> request = HttpRequest.GET("/users");
        HttpResponse<User> response = client.toBlocking().exchange(request, User.class);

        assertEquals(200, response.getStatus().getCode());
        assertNotNull(response.body());
        assertEquals("Mkyong", response.body().getName());
        assertEquals(42, response.body().getAge());
    }

    @Test
    void testGetAllUsers() {
        HttpRequest<String> request = HttpRequest.GET("/users/all");
        HttpResponse<List<User>> response = client.toBlocking().exchange(request, Argument.listOf(User.class));

        assertEquals(200, response.getStatus().getCode());
        assertNotNull(response.body());
        assertEquals(2, response.body().size());
        assertEquals("Mkyong", response.body().get(0).getName());
        assertEquals(42, response.body().get(0).getAge());
        assertEquals("Zi Lap", response.body().get(1).getName());
        assertEquals(10, response.body().get(1).getAge());
    }

}

