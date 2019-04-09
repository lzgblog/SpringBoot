package com.springboot.cache.myconfig;

import com.springboot.cache.pojo.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

//配置缓存管理器和存入为json格式的数据类型
@Configuration
public class MyRedisConfig {

    //RedisTemplate默认使用jdk序列化机制
    //我们可以手动修改数据格式的配置     将数据以json的数据格式存入Redis中
    //修改RedisAutoConfiguration类中RedisTemplate方法，并将其放入容器中
    //并修改存储的数据类型为 Employee
    @Bean
    public RedisTemplate<Object, Employee> empRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate<Object, Employee>();
        template.setConnectionFactory(redisConnectionFactory);
        //将序列化的实体类设置到序列化器中 并设置为默认
        Jackson2JsonRedisSerializer<Employee> serializer = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
        template.setDefaultSerializer(serializer);

        return template;
    }
    //只要引入Redis启动器，就会使用Redis作为缓存管理器
    //springboot通过RedisCacheManager类中的RedisCache来帮我们创建缓存组件，RedisCache通过redis缓存数据的
    //我们就可以手动修改配置 ，将自定义类型数据的empRedisTemplate放入其使其生效  以json的数据格式存储在Redis缓存中
    //修改RedisCacheConfiguration类中的RedisCacheManager方法
   // @Primary   默认使用哪个作为缓存管理器
    @Bean
    public RedisCacheManager cacheManager(RedisTemplate<Object, Employee> empRedisTemplate) {
        //将自定义的RedisTemplate放入到缓存管理器中RedisCacheManager
        RedisCacheManager cacheManager = new RedisCacheManager(empRedisTemplate);

        cacheManager.setUsePrefix(true);
        return cacheManager;
    }

}
