package com.something.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.java.Log;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Log
@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Value("${server.port}")
    private String port;

    @LoadBalanced
    @HystrixCommand(commandKey = "morningCommand", groupKey = "morningGroup", fallbackMethod = "morningFallback",
            commandProperties =
            {
                    @HystrixProperty(name = "execution.isolation.strategy",value = "THREAD"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "900")
            },
            threadPoolProperties = {
                @HystrixProperty(name = "coreSize",value = "2"),
                @HystrixProperty(name = "maxQueueSize",value="10"),
                @HystrixProperty(name = "queueSizeRejectionThreshold",value="20")
            }
    )
    @GetMapping("/morning")
    public String morning(@RequestParam("time") Date time){
        log.warning("receive time [" + time.getTime() + "]");
        return "this is port [" + port + "] say morning";
    }

    private String morningFallback(Date time){
        return "降级sorry, the request is timeout";
    }
}
