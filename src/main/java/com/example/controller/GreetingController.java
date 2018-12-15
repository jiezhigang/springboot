package com.example.controller;

import com.example.pojo.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping(path = "/greeting")
public class GreetingController {

    private static String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(path = "/greeting")
    @ResponseBody
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "world") String name){

        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }
}
