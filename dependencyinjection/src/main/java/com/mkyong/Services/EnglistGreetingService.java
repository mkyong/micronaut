package com.mkyong.Services;

import io.micronaut.context.annotation.Primary;
import jakarta.inject.Singleton;

@Singleton
@Primary // default
public class EnglistGreetingService implements GreetingService{
    @Override
    public String speak(String words) {
        return "Hello " + words;
    }
}