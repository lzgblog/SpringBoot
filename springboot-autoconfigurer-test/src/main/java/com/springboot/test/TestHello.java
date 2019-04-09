package com.springboot.test;

import com.springboot.start.myconfig.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestHello {
    @Autowired
    //使用自定义启动器中的工具类
    HelloService helloService;
    @RequestMapping("/hello")
    public String hello(String name){
        String result = helloService.sayHello(name);
        return result;
    }
}
