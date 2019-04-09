package com.springboot.start.myconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //将该类作为配置类  使用@Configuration
@ConditionalOnWebApplication  //web应用才会生效
//让xxxProperties生效加入到容器中
@EnableConfigurationProperties(HelloProperties.class) //将自定义的属性类添加到配置中才能生效
public class HelloAutoConfigurer {
    //依赖注入HelloProperties  实例化它@ConfigurationProperties(prefix = "lzg.hello")才会生效
    @Autowired
    HelloProperties helloProperties;
    //将HelloService类添加到容器中
    @Bean
    public HelloService helloService(){
        HelloService helloService = new HelloService();
        //拿到当前实例化的HelloProperties对象  其在配置文件中生效的属性数据已存入helloProperties并交给HelloService类
        helloService.setHelloProperties(helloProperties);
        return helloService;
    }
}
