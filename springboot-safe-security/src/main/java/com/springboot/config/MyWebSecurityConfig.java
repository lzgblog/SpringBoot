package com.springboot.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//自定义Security策略
//开启springsecurity注解
@EnableWebSecurity
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
    //用户授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //进行定制授权规则   在/访问路径下都可以通过  给访问level1、level2、level3路径下各定一个角色role
        http.authorizeRequests()
                .antMatchers("/" ).permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        //开启登入  http.formLogin();默认访问/login
        // 可以自定义登入的页面 自定义登录的页面的用户名和密码通过name属性传过来 这里配置获取
        //http.formLogin().usernameParameter("user").passwordParameter("pwd").loginPage("/userlogin");
        http.formLogin();
        //开启注销   http.logout();//默认访问/logout  销毁cookie
        http.logout().logoutSuccessUrl("/");//自定义注销后跳转到首页
        //开启记住用户   开启浏览器访问自动登录
        //在自定义的登录页面添加rememberme的方式  在页面提供一个name=“remeber”的属性  这里配置获取即可
        //http.rememberMe().rememberMeParameter("remeber");
        http.rememberMe();
    }

    //自定义认证策略
    //用户认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        //进行权限的认证 给定某个用户角色role
        auth.inMemoryAuthentication()
                .withUser("zhangsan").password("123456").roles("VIP1","VIP2")
                .and()
                .withUser("lisi").password("123456").roles("VIP2","VIP3");

    }
}
