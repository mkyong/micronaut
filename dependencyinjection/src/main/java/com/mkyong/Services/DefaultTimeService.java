package com.mkyong.Services;

import jakarta.inject.Singleton;
import java.time.LocalTime;

@Singleton
public class DefaultTimeService implements TimeService {
    public String getCurrentTime() {
        return LocalTime.now().toString();
    }
}
