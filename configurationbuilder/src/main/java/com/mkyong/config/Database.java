package com.mkyong.config;

public class Database {
    private String url;
    private String username;
    private String password;
    private int maxSize;
    private int minSize;

    private Database(Builder builder) {
        this.url = builder.url;
        this.username = builder.username;
        this.password = builder.password;
        this.maxSize = builder.maxSize;
        this.minSize = builder.minSize;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getMinSize() {
        return minSize;
    }

    public static class Builder {
        private String url;
        private String username;
        private String password;
        private int maxSize;
        private int minSize;

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder maxSize(int maxSize) {
            this.maxSize = maxSize;
            return this;
        }

        public Builder minSize(int minSize) {
            this.minSize = minSize;
            return this;
        }

        public Database build() {
            return new Database(this);
        }
    }
}
