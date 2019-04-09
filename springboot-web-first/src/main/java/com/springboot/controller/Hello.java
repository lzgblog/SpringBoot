package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@Controller
public class Hello {

    @RequestMapping("/hello")
    public String hello(){
        //想要跳转页面 需要配置thymeleaf模板依赖  并且跳转的页面需要放在templates文件夹下 并以html为后缀
        return "second";
    }
    @RequestMapping("/date")
    public String he(HashMap<String,Object> map){
        map.put("hello","welcome to thymeleaf");
        ArrayList<String> s = new ArrayList<>();
        s.add("a");
        s.add("b");
        s.add("c");
        map.put("list", s);
        return "success";
    }
    @RequestMapping("/se")
    //接收页面传递的数据并显示回去  http://localhost:8080/se?str=name    /  th:text="${string}"
    public String se(String str,Model model){
        model.addAttribute("model","model");
        ArrayList<String> s = new ArrayList<>();
        s.add("a");
        s.add("b");
        s.add("c");
        model.addAttribute("list",s);
        System.out.println(str);
        model.addAttribute("string",str);
        return "second";
    }
}
