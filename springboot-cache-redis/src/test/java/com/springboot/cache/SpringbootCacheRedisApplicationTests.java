package com.springboot.cache;

import com.springboot.cache.pojo.Employee;
import com.springboot.cache.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCacheRedisApplicationTests {

    @Autowired
    EmployeeService employeeService;

    //Redis提供StringRedisTemplate、RedisTemplate进行操作.
    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作字符串
    @Autowired
    RedisTemplate redisTemplate;  //操作对象

    @Autowired  //自动注入手动修改过的RedisTemplate来处理对象数据
    RedisTemplate<Object,Employee> empRedisTemplate;
    /**
     * Redis操作的数据类型
     *  stringRedisTemplate.opsForValue() 【字符串类型】
     *  stringRedisTemplate.opsForList() 【list集合】
     *  stringRedisTemplate.opsForSet() 【set集合】
     *    stringRedisTemplate.opsForHash() 【map集合】
     *
     */
    public void test(){
        //Redis存取字符串
        stringRedisTemplate.opsForValue().append("name","hello");//向redis缓存中存入值
        stringRedisTemplate.opsForValue().get("name");//向redis缓存中取数据
//        stringRedisTemplate.opsForList().leftPush();
//        stringRedisTemplate.opsForList().leftPop();

        //Redis存取对象
        Employee emp = employeeService.findEmpById(1);
        //向Redis缓存中存入Employee对象  并必须把该实体类（Employee）实现序列化 Serializable
        //但Redis中保存的数据并不是以json的方式储存  需要我们手动更改实例化配置的规则
        //修改RedisAutoConfiguration配置文件中的RedisTemplate方法，并将其放入容器中 MyRedisConfig类中
        //redisTemplate.opsForValue().set("emp-01",emp);
        empRedisTemplate.opsForValue().set("emp-01",emp);//此时Redis中的数据就是json格式的数据了

    }


    @Test
    public void contextLoads() {
        Employee emp = employeeService.findEmpById(1);
        System.out.println(emp);
    }

}
