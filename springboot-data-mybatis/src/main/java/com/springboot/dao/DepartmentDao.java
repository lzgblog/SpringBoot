package com.springboot.dao;

import com.springboot.pojo.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

//注解的方式
//指定这是一个操作数据库的mapper
// 或者在主函数入口设置Mapper的扫描@MapperScan(value="com.springboot.dao")
//@Mapper
public interface DepartmentDao {
    @Select("select * from department")
    public List<Department> findAll();
    @Select("select * from department where id=#{id}")
    public Department findById(int id);
    //添加时设置id为自增主键
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public void insertOne(Department department);
    @Delete("delete from department where id=#{id}")
    public void deleteOne(int id);
}
