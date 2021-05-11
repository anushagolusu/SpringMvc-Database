package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Dao.DeptRepo;
import com.example.demo.Model.Department;

@RestController
@RequestMapping("/rest/dept")
public class RestDeptController {
  @Autowired
  DeptRepo deptRepo;
  
  @GetMapping("/getAllDepts")
  public Iterable<Department> getAllDepts(){
	 System.out.println("*** getAllDepts ****");
	  return deptRepo.findAll();
  }
  @GetMapping("/{id}")
  public Department getOneDept(@PathVariable("id") int id) {
	  Optional<Department> dept=deptRepo.findById(id);
	  if(dept.isPresent())
		  return dept.get();
	  else 
		  throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Department Id Not Found");
  }
  
  
  @PostMapping("/add")
  public Department addDept(Department dept) {
  try {
	  System.out.println("*** add **** : " +dept);
	  
	  deptRepo.save(dept);
	  return dept;
  }
  catch(Exception ex) {
	  System.out.println(ex);
	  throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"INVAID DATA");
  }
}
  
  @DeleteMapping("/{id}")
  public void deleteDept(@PathVariable("id") int id) {
	  Optional<Department> dept=deptRepo.findById(id);
	  if(dept.isPresent()) {
		  try {
			  deptRepo.delete(dept.get());
		  }catch(Exception ex) {
			  System.out.println(ex);
			  throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	  }else {
		  throw new  ResponseStatusException(HttpStatus.NOT_FOUND,"Department Id Not Found");
	  }
  }
  
  @PutMapping("/{id}")
  public void updateDept(@PathVariable("id") int id,Department newDept) {
	  Optional<Department> dept=deptRepo.findById(id);
	  if(dept.isPresent()) {
		  try {
			  Department dbDept= dept.get();
			  dbDept.setName(newDept.getName());
			  deptRepo.save(dbDept);
		  }catch(Exception ex) {
			  System.out.println(ex);
			  throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	  }else {
		  throw new  ResponseStatusException(HttpStatus.NOT_FOUND,"Department Id Not Found");
	  }
  }
  
  
}
