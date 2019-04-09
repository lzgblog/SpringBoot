package com.springboot.exception;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

//实例化添加到容器中
@Component
public class MyDefaultErrorAttributes extends DefaultErrorAttributes {
    @Override
    //将自定义设置的内容添加到DefaultErrorAttributes中后 可以获取得到
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(requestAttributes, includeStackTrace);
        //第二个参数为 域  0为request域  1为session域
        Object ext = requestAttributes.getAttribute("ext",0);
        //将获得的内容放入DefaultErrorAttributes中生效
        map.put("ext",ext);
        map.put("person","lzg");
        return map;
    }
}
