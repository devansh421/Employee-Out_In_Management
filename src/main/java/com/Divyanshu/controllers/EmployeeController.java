package com.Divyanshu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Divyanshu.models.Employee;
import com.Divyanshu.services.EmployeeService;

@Controller
@RequestMapping("employee-out-in/employee")
public class EmployeeController 
{
	@Autowired private EmployeeService service;
	
	@RequestMapping("add")
	public String getInsertView(Model model)
	{
		return "employee/insert";
	}
	@RequestMapping("save-record")
	public String saveEmployeeRecord(Employee emp,Model model)
	{
		int eid=emp.getEid();
		if(service.isEmployeeExist(eid))
		{
			model.addAttribute("eid",eid);
			model.addAttribute("name",emp.getName());
			model.addAttribute("msg","Employee with given id already exists");
			return "employee/insert";
		}
		service.saveRecord(emp);
		return "employee/save";
	}
	@RequestMapping("details")
	public String getEmployeeDetails(Model model,int eid)
	{
		Employee emp=service.getEmplaye(eid);
		model.addAttribute("employee",emp);
		return "employee/employee-details";
	}
}
