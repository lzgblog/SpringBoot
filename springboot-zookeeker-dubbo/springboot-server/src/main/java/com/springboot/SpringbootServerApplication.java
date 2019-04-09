package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//1.安装zookeeper  默认端口2181 引入zkclient 和 dubbo依赖
//2.配置配置文件中dubbo的name和address、base-package
//3.使用dubbo包下的@Service发布 服务  需要写service服务的接口和实现类   client只需要拿到接口即可调用方法
@SpringBootApplication
public class SpringbootServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootServerApplication.class, args);
    }

}
