package com.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration：指明当前类是一个配置类；就是来替代之前的Spring配置文件
//        *
//        * 在配置文件中用<bean><bean/>标签添加组件
@Configuration
public class ConfigClass {
    //将方法的返回值添加到容器中；容器中这个组件默认的id就是方法名
    @Bean
    public ConfigClass mySpringConfig(){  //bean的id为方法名  mySpringConfig
        System.out.println("springboot的配置类");
        return new ConfigClass();//返回的对象放入到容器中
    }
}
