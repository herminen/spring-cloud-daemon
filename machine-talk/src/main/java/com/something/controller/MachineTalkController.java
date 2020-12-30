package com.something.controller;

import com.something.service.GreetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RequestMapping("/machine")
@RestController
public class MachineTalkController {

    @Value("server.port")
    private String port;

    @Resource
    GreetingService greetingService;

    @GetMapping("/talk")
    public String talk(@RequestParam("name") String name){
        String morning = greetingService.morning(new Date());

        return "hello ["+name+"] this is machine " + port + " speeking, greeting: [" + morning + "]";
    }
}
