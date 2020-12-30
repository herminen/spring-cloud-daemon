package com.something.fallback;

import com.something.service.GreetingService;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class GreetingServiceFallBack implements GreetingService {
    @Override
    public String morning(Date time) {
        return "sorry, service timeout";
    }
}
