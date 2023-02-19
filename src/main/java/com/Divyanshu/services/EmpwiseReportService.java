package com.Divyanshu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Divyanshu.models.EmployeeOutIn;
import com.Divyanshu.repositories.EmpwiseReportRepository;
import com.Divyanshu.util.LocalDateTime;

@Service
public class EmpwiseReportService 
{
	@Autowired private EmpwiseReportRepository repo;

	public List<EmployeeOutIn> getCurrentDateList(int eid) 
	{
		return repo.findByDate(eid,LocalDateTime.getCurrentDate());
	}
	public List<EmployeeOutIn> getAnyDateList(int eid,String date) 
	{
		List<EmployeeOutIn> list= repo.findByDate(eid,date);
		return list;
	}
	public List<EmployeeOutIn> getDateBetweenList(int eid,String date1, String date2)
	{
		List<EmployeeOutIn> list= repo.findDateBetweenList(eid,date1,date2);
		return list;
	}
}
