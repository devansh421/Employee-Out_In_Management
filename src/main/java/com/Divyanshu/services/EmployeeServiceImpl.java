package com.Divyanshu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Divyanshu.models.Employee;
import com.Divyanshu.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired private EmployeeRepository repo;

	public void saveRecord(Employee emp) 
	{
		repo.save(emp);
	}
	public boolean isEmployeeExist(int eid) 
	{
		return repo.existsById(eid);
	}
	public List<Employee> getEmployeeList() 
	{
		return repo.findAll();
	}
	public String getEmplayeName(int eid) 
	{
		return repo.getEmployeeName(eid);
	}
	public Employee getEmplaye(int eid) 
	{
		Employee emp=repo.findById(eid).orElse(null);
		return emp;
	}
}
