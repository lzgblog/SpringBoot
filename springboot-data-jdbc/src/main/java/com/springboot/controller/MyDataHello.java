package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MyDataHello {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/hello")
    public List<Map<String, Object>> hello(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from department");
        return maps;
    }
}
