package com.Divyanshu.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Divyanshu.models.Employee;
import com.Divyanshu.models.EmployeeOutIn;
import com.Divyanshu.services.EmployeeService;
import com.Divyanshu.services.EmpwiseReportService;
import com.Divyanshu.util.LocalDateTime;

@Controller
@RequestMapping("employee-out-in/empwise-report")
public class EmployeeWiseReportController 
{
	@Autowired
	private EmployeeService eservice;
	@Autowired
	private EmpwiseReportService service;
	
	@RequestMapping("list")
	public String getEmployeeListView(Model model)
	{
		List<Employee> list=eservice.getEmployeeList();
		model.addAttribute("elist",list);
		return "empwise-report/employee-list";
	}
	@RequestMapping("date")
	public String getChooseDateView(int eid,Model model)
	{
		String name=eservice.getEmplayeName(eid);
		model.addAttribute("cdate",LocalDate.now());
		model.addAttribute("eid",eid);
		model.addAttribute("name",name);
		return "empwise-report/choose-date";
	}
	@RequestMapping("current-date-report")
	public String getCurrentDateReport(int eid,String name,Model model)
	{
		List<EmployeeOutIn> list=service.getCurrentDateList(eid);
		model.addAttribute("list",list);
		model.addAttribute("name",name);
		return "empwise-report/current-date-report";
	}
	@RequestMapping("any-date-report")
	public String getAnyDateReport(int eid,String name,String date,Model model)
	{
		date=LocalDateTime.chageDateFormat(date);
		List<EmployeeOutIn> list=service.getAnyDateList(eid,date);
		model.addAttribute("list",list);
		model.addAttribute("date",date);
		model.addAttribute("name",name);
		return "empwise-report/any-date-report";
	}
	@RequestMapping("date-between-report")
	public String getDateBetweenReport(int eid,String name,String date1,String date2,Model model)
	{
		date1=LocalDateTime.chageDateFormat(date1);
		date2=LocalDateTime.chageDateFormat(date2);
		List<EmployeeOutIn> list=service.getDateBetweenList(eid,date1,date2);
		model.addAttribute("list",list);
		model.addAttribute("date1",date1);
		model.addAttribute("date2",date2);
		model.addAttribute("name",name);
		return "empwise-report/date-between-report";
	}
}
