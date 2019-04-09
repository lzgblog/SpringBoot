package com.springboot.controller;

import com.springboot.dao.DepartmentDao;
import com.springboot.dao.EmployeeDao;
import com.springboot.entities.Department;
import com.springboot.entities.Employee;
import com.springboot.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Map;


@Controller
public class MyCotroller {
    //登入操作
    //@PostMapping("/login") == @RequestMapping("/login",method =  RequestMethod.POST)
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session, Map<String,String> map){
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){

            //将用户名放入session域对象中
            //当html页面需要获取session域中的值  在thymeleaf模板下的获取方式
            //  th:text="${session.user}"
            session.setAttribute("user",username);
            return "redirect:/main.html";
        }else{
            //  th:text="${msg}"
            map.put("msg","密码错误！！！");
            return "login";
        }
    }

    //部门
    @Autowired
    DepartmentDao departmentDao;
    //员工
    @Autowired
    EmployeeDao employeeDao;
    //查询所有员工信息
    @RequestMapping("/findCustList")
    public String findCustList(Model model){
        Collection<Employee> emps = employeeDao.getAll();
        //将查询出的数据回显到list页面
        model.addAttribute("emps",emps);
        return "list";
    }
    //跳转到添加员工页面
    @RequestMapping("/addPage")
    public String addPage(Model model){
        //将所有部门写回
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps",departments);
        return "add";
    }
    //添加员工信息
    //Post方式提交   写成PostMapping   数据自动封装到Employee对象中， 其值会一一匹配
    @PostMapping("/addEmp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        //重定向回查询数据  跳回list页面
        return "redirect:/findCustList";
    }
   //以restfull的形式样式丢了   查询单个员工信息  并回显
    /*@RequestMapping("/selectEmp")
    public String selectEmp(@PathVariable("id") int id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        System.out.println("x xxxx");
        return "emp";
    }*/

   /* @RequestMapping("/selectEmp")
    public String selectEmp(){

        return "emp";
    }*/
    //删除用户
   @DeleteMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id") int id){
       employeeDao.delete(id);
       return "redirect:/findCustList";
   }
    //以restfull的形式样式丢了   查询单个员工信息  并回显
   @RequestMapping("/selectEmp")
    public String selectEmp(Model model){
       Employee employee = employeeDao.get(1004);
       model.addAttribute("emp",employee);
       return "emp";
   }
   //自定义异常页面
    @ResponseBody
    @RequestMapping("/hel")
    public String hel(@RequestParam("name") String name){
       if("aaa".equals(name)){
            throw  new MyException();
        }
       return "hello world";
    }
}
