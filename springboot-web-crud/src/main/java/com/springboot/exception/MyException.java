package com.springboot.exception;

public class MyException extends RuntimeException{
    public MyException() {
        super("用户不存在异常");
    }
}
