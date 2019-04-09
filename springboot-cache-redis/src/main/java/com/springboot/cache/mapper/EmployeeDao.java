package com.springboot.cache.mapper;

import com.springboot.cache.pojo.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmployeeDao {
    @Select("select * from employee where id=#{id}")
    public Employee findEmpById(int id);
    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id=#{id}")
    public void updateEmp(Employee employee);
    @Delete("delete from employee where id=#{id}")
    public void delEmp(int id);
}
