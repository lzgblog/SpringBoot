package com.spingboot.rabbitmq.myconfig;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//配置消息格式  修改amqp包中的MessageConverter类
@Configuration
public class MyRabbitConfig {
    @Bean
    public MessageConverter messageConverter(){
        //将json格式的类Jackson2JsonMessageConverter 放入容器中
        return new Jackson2JsonMessageConverter();
    }
}
