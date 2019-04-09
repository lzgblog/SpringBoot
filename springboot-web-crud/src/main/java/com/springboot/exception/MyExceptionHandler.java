package com.springboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

//自定义异常  返回自定义json内容
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(MyException.class)
    public  String handler(Exception e,HttpServletRequest request){
        HashMap<String, Object> map = new HashMap<>();
        //传入我们自己的错误状态码  4xx 5xx，否则就不会进入定制错误页面的解析流程
        /**
         * Integer statusCode = (Integer) request
         .getAttribute("javax.servlet.error.status_code");
         */                                                 //     状态码
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("error","用户异常");
        map.put("message",e.getMessage());
        //将集合map放入Reqeust域中   等待DefaultErrorAttributes的子类获取
        request.setAttribute("ext",map);
        //转发到error下进行解析
        return  "forward:/error";
    }
}
