package com.springboot.cache.controller;

import com.springboot.cache.pojo.Employee;
import com.springboot.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/emp/{id}")
    public Employee findEmpById(@PathVariable("id") int id){
        Employee emp=employeeService.findEmpById(id);
        return emp;
    }
    @RequestMapping("/emp")
    public Employee updateEmp(Employee employee){
        employeeService.updateEmp(employee);
        return employee;
    }
    @RequestMapping("/del/{id}")
    public void del(@PathVariable("id") int id){
        employeeService.delEmpById(id);
    }
}

