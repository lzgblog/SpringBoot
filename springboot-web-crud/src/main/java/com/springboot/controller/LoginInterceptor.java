package com.springboot.controller;

import org.omg.PortableInterceptor.Interceptor;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//拦截器  登入检查
public class LoginInterceptor implements HandlerInterceptor {

    //处理前
    @Override
    public boolean preHandle(HttpServletRequest Request, HttpServletResponse Response, Object o) throws Exception {
        //通过Request获取Session 取得session域中的uesr值
        HttpSession session = Request.getSession();
        Object user = session.getAttribute("user");
        if(!StringUtils.isEmpty(user)){
            //不为空   用户已登入  放行
            return true;
        }else {
            //user为空  则用户未登入
            Request.setAttribute("msg","还没有登入！！");
            Request.getRequestDispatcher("/index.html").forward(Request,Response);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
