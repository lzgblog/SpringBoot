package com.springboot.javabean.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
//获取Person类中设置好的值
    @Value("${person.name}")
    private String name;
    @RequestMapping("/hello")
    public String hello(){
        return "hello"+name;
    }
}
