package com.spingboot.rabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    //对消息队列进行监听  并确定监听哪个消息队列  只要有消息到atguigu.news队列中就会执行
    @RabbitListener(queues = "atguigu.news")
    public void rabbitListenner(){
        System.out.println("队列接收到消息！！");
    }
}
