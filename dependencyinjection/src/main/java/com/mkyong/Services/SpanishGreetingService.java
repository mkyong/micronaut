package com.mkyong.Services;

import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Singleton
@Named("Spanish")
public class SpanishGreetingService implements GreetingService {
    @Override
    public String speak(String words) {
        return "Hola " + words;
    }
}
