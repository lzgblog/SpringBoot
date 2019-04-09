package com.spingboot.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//消息队列
@SpringBootApplication
//开启RabbitMq的注解方式  之后才可以使用消息监听 @RabbitListener
@EnableRabbit
public class SpringbootRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRabbitmqApplication.class, args);
    }

}
