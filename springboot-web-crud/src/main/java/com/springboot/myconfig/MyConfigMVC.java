package com.springboot.myconfig;

import com.springboot.controller.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//扩展WebMvc的功能
@Configuration
public class MyConfigMVC extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       super.addViewControllers(registry);
        //自定义配置默认首页
        //registry.addViewController("/index.html").setViewName("login");
    }
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            //注册拦截器
            /*@Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                //注册拦截器  添加需要拦截的路径"/**"拦截所有目录  排除（excludePathPatterns）一些路径
                registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/","/index.html","/login");
            }
*/
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //super.addViewControllers(registry);
                //前端页面跳转页面会进这里
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");


            }
        };

        return adapter;
    }
    //springboot的国际化 LocaleResolver类 默认使用浏览器的规范  需要我们手动配置携带区域信息
    // 即获取携带的国际化标准  并将组件放入到容器中
    //国际化Locale（区域信息对象）；LocaleResolver（获取区域信息对象）；
    @Bean
    public LocaleResolver localeResolver(){
        LocaleResolver resolver = new LocaleResolver() {
            @Override
            public Locale resolveLocale(HttpServletRequest Request) {
                String l = Request.getParameter("l");
                Locale locale=Locale.getDefault();//默认
                //判断l是否为空
                if(!StringUtils.isEmpty(l)){
                    String[] s = l.split("_");//分割字符串  请求传达为：en_US 或 zh_CN
                    locale = new Locale(s[0],s[1]);//第一个参数为语言  第二个参数为国家

                }
                return locale;
            }

            @Override
            public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

            }
        };
        return resolver;
    }

}
