package com.example.demo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.Department;

public interface DeptRepo extends CrudRepository<Department,Integer>{
 @Query(" from Department d where d.id> ?1")
 List<Department> getRecentDepartments(int deptid);
 
 @Query(value="select avg(length(department_name)) from departments",nativeQuery=true)
 int getAvgLength();
}
