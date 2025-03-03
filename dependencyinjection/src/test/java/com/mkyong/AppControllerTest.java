package com.mkyong;

import com.mkyong.Services.GreetingService;
import com.mkyong.Services.TimeService;
import com.mkyong.controllers.AppController;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

@MicronautTest
class AppControllerTest {

    @Test
    void testGreeting() {
        GreetingService mockService = mock(GreetingService.class);
        TimeService mockTimeService = mock(TimeService.class);

        when(mockService.speak("Micronaut"))
                .thenReturn("Hello, Micronaut");
        when(mockTimeService.getCurrentTime())
                .thenReturn("10:00 AM");

        AppController controller = new AppController(mockService, mockTimeService);
        controller.sayHello();

        verify(mockService, times(1)).speak("Micronaut");
        verify(mockTimeService, times(1)).getCurrentTime();
    }

}
