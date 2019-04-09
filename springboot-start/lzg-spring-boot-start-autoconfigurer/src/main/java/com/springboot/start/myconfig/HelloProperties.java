package com.springboot.start.myconfig;


import org.springframework.boot.context.properties.ConfigurationProperties;

//定义一个获取前后缀的属性文件   能够读取到properties配置文件中配置的数据
//使用ConfigurationProperties(prefix="lzg.hello")  属性前缀为lzg.hello
@ConfigurationProperties(prefix = "lzg.hello")
public class HelloProperties {
    private String prefix;
    private  String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
