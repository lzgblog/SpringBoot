package com.springboot.dao;

import com.springboot.pojo.Employee;

import java.util.List;

//使用配置文件的方式
public interface EmployeeDao {

    public List<Employee> findAll();

    public Employee findById(int id);

    public void insertOne(Employee employee);

}
