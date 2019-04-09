package com.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld_Quick {
    @RequestMapping("/hello")
    public String hello(){
        return "hello springboot quick!";
    }
}
