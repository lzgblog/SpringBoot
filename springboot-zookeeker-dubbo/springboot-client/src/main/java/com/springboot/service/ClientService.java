package com.springboot.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    //使用@Reference 远程调用该接口全限定名称发布的服务
    @Reference  //这里是alibaba包下的
    MyService myService;
    public String getTicket(){
        //获取MyService发布的方法
        return "买到："+myService.buyTicket();
    }
}
