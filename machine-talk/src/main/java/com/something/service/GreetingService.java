package com.something.service;

import com.something.fallback.GreetingServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@FeignClient(value = "talk-greeting", fallback = GreetingServiceFallBack.class)
public interface GreetingService {

    @RequestMapping("/greeting/morning")
    String morning(@RequestParam("time") Date time);
}
