package com.springboot.start.myconfig;

public class HelloService {

    //配置一个前后缀的属性类
    HelloProperties helloProperties;
    //提供setter、getter方法
    public HelloProperties getHelloProperties() {
        return helloProperties;
    }
    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    //定义一个方法  等待调用
    public String sayHello(String name){

        //返回数据  其前缀和后缀由我们自动配置好  调用者只需要在配置文件写就可以输出
        return helloProperties.getPrefix()+"-"+name+"-"+helloProperties.getSuffix();
    }
}
