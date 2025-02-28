package com.mkyong.config;

import jakarta.inject.Singleton;

@Singleton
public class AppService {

    private final AppConfig appConfig;

    public AppService(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public void printConfig() {
        System.out.println("App Name: " + appConfig.getName());
        System.out.println("App Version: " + appConfig.getVersion());
        System.out.println("Supported Languages: " + String.join(", ", appConfig.getSupportedLanguages()));
        System.out.println("Metadata: " + appConfig.getMetadata());
    }
}
