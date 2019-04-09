package com.springboot.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    //异步处理
    @Async
    public void sleepTime(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //定时  cron="秒 分 时 日 月 星期"
    @Scheduled(cron = "0 * * * * *")//整秒启动该方法  即1分钟启动一次
    public void scheduled(){
        System.out.println("定时启动。。。。。");
    }
}
