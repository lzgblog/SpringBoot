package com.spingboot.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {

    @Autowired
    AmqpAdmin amqpAdmin;//用java代码的方式创建交换器Exchange、消息队列Queue、绑定规则Bingding
    @Test
    public void test(){
        //创建交换器Exchange  指定交换器的类型为点对点（Direct） 并命名
        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));
        //创建消息队列
        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue"));
        //进行绑定
        // 参数为：目的地即消息队列，目的地类型传到消息队列中，指定交换器，规定一个路由键即绑定规则，传达的参数为null
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue",Binding.DestinationType.QUEUE,
                "amqpAdmin.exchange","amqp.hh",null));
    }

    @Autowired
    RabbitTemplate rabbitTemplate;//使用RabbitTemplate对象来对rabbit进行操作
    @Test
    public void send(){
        //发送消息   rabbit默认对数据序列化  我们可以自定义数据序列化为json格式类型 如MyRabbitConfig
        HashMap<String, Object> map = new HashMap<>();
        map.put("exchange","direct");
        map.put("message", Arrays.asList("hello world","第一个消息"));
        //direct  点对点模式
        //第一个参数exchange：交换器  我们定义的exchange.direct
        //第二个参数routingKey：路由键 自定义的绑定规则  atguigu.news
        //第三个参数Object: 给消息队列发送的消息 可以发送对象
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.emps",map);
        //fanout 广播模式  路由键不需要写  确定交换器fanout即可
        //rabbitTemplate.convertAndSend("exchange.fanout","",map);
        //topic  匹配模式
       //rabbitTemplate.convertAndSend("exchange.topic","atguigu.#",map);
    }
    @Test
    public void contextLoads() {
        //接收消息队列的消息
        //参数为 自定义的消息队列的名称
        Object o = rabbitTemplate.receiveAndConvert("atguigu.emps");
        System.out.println(o);

    }

}
