package com.Divyanshu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Divyanshu.models.Employee;
import com.Divyanshu.models.EmployeeOutIn;
import com.Divyanshu.services.EmployeeOutInService;
import com.Divyanshu.services.EmployeeService;
import com.Divyanshu.util.LocalDateTime;

@Controller
@RequestMapping("employee-out-in/outin")
public class EmployeeOutInController 
{
	@Autowired private EmployeeOutInService service;
	@Autowired private EmployeeService eservice;
	
	@RequestMapping("out")
	public ModelAndView getEmployeeOutView()
	{
		ModelAndView mv=new ModelAndView();
		List<Employee> list=eservice.getEmployeeList();
		mv.addObject("elist",list);
		mv.setViewName("empoutin/employee-out");
		return mv;
	}
	@RequestMapping("save-outtime")
	public String saveEmployeeOutTime(EmployeeOutIn outtime,Model model)
	{
		String name=eservice.getEmplayeName(outtime.getEid());
		model.addAttribute("name",name);
		if(service.saveOuttime(outtime))
			return "empoutin/outtime-save";
		return "empoutin/outtime-fail";
	}
	@RequestMapping("in")
	public ModelAndView getEmployeeInView()
	{
		ModelAndView mv=new ModelAndView();
		List<Employee> list=eservice.getEmployeeList();
		mv.addObject("elist",list);
		mv.setViewName("empoutin/employee-in");
		return mv;
	}
	@RequestMapping("save-intime")
	public String saveEmployeeInTime(int eid,Model model)
	{
		String name=eservice.getEmplayeName(eid);
		model.addAttribute("name",name);
		if(service.updateIntime(eid))
			return "empoutin/intime-save";
		return "empoutin/intime-fail";
	}
	
}
