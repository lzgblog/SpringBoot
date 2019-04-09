package com.springboot.task.controller;

import com.springboot.task.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    MyService myService;
    @RequestMapping("/hello")
    public String hello(){
        myService.sleepTime();
        return "hello world!!";
    }
}
