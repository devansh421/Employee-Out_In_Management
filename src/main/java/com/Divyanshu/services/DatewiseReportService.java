package com.Divyanshu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Divyanshu.models.EmployeeOutIn;
import com.Divyanshu.repositories.DatewiseReportRepository;
import com.Divyanshu.util.LocalDateTime;

@Service
public class DatewiseReportService 
{
	@Autowired private DatewiseReportRepository repo;

	public List<EmployeeOutIn> getCurrentDateList() 
	{
		return repo.findByDate(LocalDateTime.getCurrentDate());
	}
	public List<EmployeeOutIn> getAnyDateList(String date) 
	{
		List<EmployeeOutIn> list= repo.findByDate(date);
		return list;
	}
	public List<EmployeeOutIn> getDateBetweenList(String date1, String date2)
	{
		List<EmployeeOutIn> list= repo.findDateBetweenList(date1,date2);
		return list;
	}
}
