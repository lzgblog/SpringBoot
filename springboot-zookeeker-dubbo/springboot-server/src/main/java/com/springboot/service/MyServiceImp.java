package com.springboot.service;

import com.alibaba.dubbo.config.annotation.Service;

//@Service使用alibaba的包
@Service
public class MyServiceImp implements MyService {
    //发布买票服务
    @Override
    public String buyTicket() {
        return "《我的青春恋爱物语果然有问题》";
    }
}
