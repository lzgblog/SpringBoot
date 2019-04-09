package com.springboot;

import com.springboot.javabean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootProertiesConfigApplicationTests {

    @Autowired
    ApplicationContext ac;

    @Autowired
    Person person;
    @Test
    public void contextLoads() {
        System.out.println(person);
    }


    @Test
    public void test1(){
        boolean s = ac.containsBean("springbean");
        System.out.println(s);
    }
    @Test
    public void test2(){
        boolean my = ac.containsBean("mySpringConfig");
        System.out.println(my);
    }
}
