package com.springboot.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//扫描映射文件的包
@MapperScan("com.springboot.cache.mapper")
@SpringBootApplication
//开启缓存
@EnableCaching
public class SpringbootCacheRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCacheRedisApplication.class, args);
    }

}
