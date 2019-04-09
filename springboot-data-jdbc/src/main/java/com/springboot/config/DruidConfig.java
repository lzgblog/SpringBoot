package com.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//导入Druid数据源  并需要手动将DruidDataSource放入容器中
@Configuration
public class DruidConfig {

    //将配置文件中的属性进行一一映射
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    //配置Druid的监控
    //1、配置一个管理后台的Servlet  注册Servlet组件  需要使用StatViewServlet这个Servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        //进入后台路径 http://localhost:8080/druid
        ServletRegistrationBean stat = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        HashMap<String, String> map = new HashMap<>();
        //到StatViewServlet的父类ResourceServlet中寻找属性并进行设置
        //后台监控 登入用户账号
        map.put("loginUsername","admin");
        //密码
        map.put("loginPassword","123456");
        map.put("loginPassword","123456");
        map.put("allow","");//默认就是允许所有访问
        map.put("deny","127.0.0.1");
        //将配置进行添加到初始化
        stat.setInitParameters(map);
        return  stat;
    }
    //2、配置一个web监控的filter   注册filter组件  使用WebStatFilter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> map = new HashMap<>();
        //排除过滤
        map.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(map);
        //过滤的路径
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
/*
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return  new DruidDataSource();
    }

    //配置Druid的监控
    //1、配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> initParams = new HashMap<>();

        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","123456");
        initParams.put("allow","");//默认就是允许所有访问
        initParams.put("deny","127.0.0.1");

        bean.setInitParameters(initParams);
        return bean;
    }


    //2、配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");

        bean.setInitParameters(initParams);

        bean.setUrlPatterns(Arrays.asList("/*"));

        return  bean;
    }

}
*/
