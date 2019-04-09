package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ImportResource;

/**
 * @ImportResource 导入spring的配置文件 让spring的配置生效
 */
@ImportResource(locations = "classpath:beans.xml")
@SpringBootApplication
public class SpringbootProertiesConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootProertiesConfigApplication.class, args);
    }

}