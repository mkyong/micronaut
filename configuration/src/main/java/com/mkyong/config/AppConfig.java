package com.mkyong.config;

import io.micronaut.context.annotation.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties("app")
public class AppConfig {

    private String name;

    private int version;
    private List<String> supportedLanguages;
    private Map<String, String> metadata;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<String> getSupportedLanguages() {
        return supportedLanguages;
    }

    public void setSupportedLanguages(List<String> supportedLanguages) {
        this.supportedLanguages = supportedLanguages;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
}
