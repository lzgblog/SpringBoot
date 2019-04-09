package com.springboot;

import com.springboot.service.ClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootClientApplicationTests {

    @Autowired
    ClientService clientService;
    @Test
    public void contextLoads() {
        String result = clientService.getTicket();
        System.out.println(result);
    }

}
