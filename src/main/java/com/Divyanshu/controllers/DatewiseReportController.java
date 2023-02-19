package com.Divyanshu.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.Divyanshu.models.EmployeeOutIn;
import com.Divyanshu.services.DatewiseReportService;
import com.Divyanshu.util.LocalDateTime;


@Controller
@RequestMapping("employee-out-in/datewise-report")
public class DatewiseReportController 
{
	@Autowired private DatewiseReportService  service;
	
	@RequestMapping("date")
	public String getChooseDateView(Model model)
	{
		model.addAttribute("cdate",LocalDate.now());
		return "datewise-report/choose-date";
	}
	@RequestMapping("current-date-report")
	public String getCurrentDateReport(Model model)
	{
		List<EmployeeOutIn> list=service.getCurrentDateList();
		model.addAttribute("list",list);
		return "datewise-report/current-date-report";
	}
	@RequestMapping("any-date-report")
	public String getAnyDateReport(String date,Model model)
	{
		date=LocalDateTime.chageDateFormat(date);
		List<EmployeeOutIn> list=service.getAnyDateList(date);
		model.addAttribute("list",list);
		model.addAttribute("date",date);
		return "datewise-report/any-date-report";
	}
	@RequestMapping("date-between-report")
	public String getDateBetweenReport(String date1,String date2,Model model)
	{
		date1=LocalDateTime.chageDateFormat(date1);
		date2=LocalDateTime.chageDateFormat(date2);
		List<EmployeeOutIn> list=service.getDateBetweenList(date1,date2);
		model.addAttribute("list",list);
		model.addAttribute("date1",date1);
		model.addAttribute("date2",date2);
		return "datewise-report/date-between-report";
	}
}
