package com.example.demo.Controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Dao.DeptRepo;
import com.example.demo.Model.Department;
@Controller
public class DeptController {
 @Autowired
 private DeptRepo depts;
 
 @RequestMapping("/deptlist")
 public String getDeptList(ModelMap model) {
	 System.out.println("depts.findAll() : " +depts.findAll());
	 model.addAttribute("depts",depts.findAll());
	return "deptlist";
 }
 
 @RequestMapping("/addDept")
 public String addDept(ModelMap model) 
 {
	 Department d=new Department();
	 model.addAttribute("dept",d);
	 return "add_dept";
 }
 
 @RequestMapping(value="/addDept",method=RequestMethod.POST)
 public String addDept(@Valid Department d,Errors errors,ModelMap model) {
	 try {
		 if(errors.getErrorCount()>0) 
			 throw new RuntimeException(errors.toString());
		 if(depts.findById(d.getId()).isPresent())
			 throw new RuntimeException("Dept Id Exists");
		 
		 depts.save(d);
		 return "redirect:/deptlist";
	 }
	 catch(Exception ex) {
		 model.addAttribute("dept",d);
		 model.addAttribute("message",ex.getMessage());
		 return "add_dept";
	 }
 }
 
 @RequestMapping("/deletedept/{id}")
 public String deletedept(@PathVariable("id") int id,ModelMap model) {
	 Optional<Department> dept=depts.findById(id);
	 if(dept.isPresent()) {
		 depts.delete(dept.get());
		 return "redirect:/deptlist";
	 }
	 else {
		 model.addAttribute("error","Department not found!");
		 return "delete_dept";
	 }
 }
 
 @RequestMapping("/editdept/{id}")
 public String editDept(@PathVariable("id") int id,ModelMap model) {
	 Optional<Department> dept=depts.findById(id);
	 if(dept.isPresent()) 
		 model.addAttribute("dept",dept.get());
	 else 
		model.addAttribute("error","Department not found!"); 
	 
	return "edit_dept";
	 
 }
 
 @RequestMapping(value="/editdept/{id}",method=RequestMethod.POST)
 public String updateDept(@PathVariable("id") int id,Department d,ModelMap model) {
	 try {
		 Optional<Department> dept=depts.findById(d.getId());
		 if(dept.isPresent()) 
			 depts.save(d);
		 else
			 throw new Exception("Invalid Department Id");
		 return "redirect:/deptlist";
	 }
	 catch(Exception ex) {
		 model.addAttribute("dept",d);
		 model.addAttribute("error","Department not found!");
		 return "edit_dept";
	 }
 }
}

