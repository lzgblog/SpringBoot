package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//1.引入zkclient 和 dubbo依赖
//2.调用端只需要配置配置文件中dubbo的name和address
//3.并需要把发布服务的接口即包名复制过来  保证该接口（MyService接口）的全限定名称一样 即包名+接口一样
//4.在注入的接口上使用@Reference 远程使用发布的服务
@SpringBootApplication
public class SpringbootClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootClientApplication.class, args);
    }

}
