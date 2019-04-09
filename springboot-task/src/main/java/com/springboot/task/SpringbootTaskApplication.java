package com.springboot.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//springboot任务   1、异步  2、定时  3、邮件
@SpringBootApplication
//开启异步注解任务
@EnableAsync
//开启定时注解任务
@EnableScheduling
public class SpringbootTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTaskApplication.class, args);
    }

}
