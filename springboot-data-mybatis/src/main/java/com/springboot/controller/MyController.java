package com.springboot.controller;


import com.springboot.dao.DepartmentDao;
import com.springboot.dao.EmployeeDao;
import com.springboot.pojo.Department;
import com.springboot.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class MyController {
    /*@Autowired
    JdbcTemplate jdbcTemplate;
    @ResponseBody
    @RequestMapping("/hello")
    public List<Map<String, Object>> hello(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from department");
        return maps;
    }*/
    @Autowired
    DepartmentDao departmentDao;
    @ResponseBody
    @RequestMapping("/findOne/{id}")
        public Department findOne(@PathVariable("id") int id){

            Department result = departmentDao.findById(id);
            return result;

    }
    @ResponseBody
    @GetMapping("/insert")
    public Department insertOne(Department departmentName){
        departmentDao.insertOne(departmentName);
        return departmentName;
    }

    @ResponseBody
    @RequestMapping("/findAll")
    public  List<Department> findAll(){

        List<Department> result = departmentDao.findAll();
        return result;

    }
    @Autowired
    EmployeeDao employeeDao;
    @ResponseBody
    @RequestMapping("/findById/{id}")
    public Employee findById(@PathVariable("id") int id){
        Employee result = employeeDao.findById(id);
        return result;
    }
    @ResponseBody
    @RequestMapping("/findEmp")
    public  List<Employee> findById(){
        List<Employee> result = employeeDao.findAll();
        return result;
    }
    @ResponseBody
    @RequestMapping("/insertOne")
    public Employee insertOne(Employee employee){
        employeeDao.insertOne(employee);
        return employee;
    }
}
