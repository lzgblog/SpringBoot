package com.springboot.cache.service;

import com.springboot.cache.mapper.EmployeeDao;
import com.springboot.cache.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

//全局配置cacheNames   cacheManager指定缓存管理器
//@CacheConfig(cacheNames = "emp")
@Service
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    //加入缓存  需要表明cacheNames或value， 不写key 默认参数作为key
    //condition  当满足条件时执行  ； unless  当满足条件中不执行
    @Cacheable(cacheNames = "emp",key="#id"/*,condition="#id>1"*/)
    public Employee findEmpById(int id){
        System.out.println("查询员工号："+id);
        Employee emp = employeeDao.findEmpById(id);
        return emp;
    }
    //更新缓存   在进行数据库更新数据的同时将更新后的数据存入缓存中  并需要和查询中定义的key一致  否则
    //否则更新后 确实把数据存入cacheNames=“emp”的缓存中 但再次查询数据时并不是更新后的数据
    //由于key不同，得到的数据就会不同   并且该方法中必须有return  才能拿到employee中的数据  否则result无效
    //@Cacheable 中不能使用result
    //key写法： key="#employee.id"  相等于  key="#result.id"
    @CachePut(cacheNames = "emp",key="#employee.id")
    public Employee updateEmp(Employee employee){
        employeeDao.updateEmp(employee);
        return employee;
    }
    //删除缓存
    //allEntries = true 执行该将缓存中的所有数据删除掉
    //beforeInvocation  指定缓存的清除是否在方法之前，默认false
    //beforeInvocation=false  默认在方法执行之后执行   当出现异常时不会执行缓存清除
    //beforeInvocation=true   在方法执行之前执行   方法中出现异常也会清除缓存
    @CacheEvict(cacheNames = "emp",key="#id")
    public void delEmpById(int id){
        System.out.println("删除缓存数据："+id);
        //employeeDao.delEmp(id);
    }

}
