package com.Divyanshu.services;

import java.util.List;

import com.Divyanshu.models.Employee;

public interface EmployeeService 
{
	void saveRecord(Employee emp);

	boolean isEmployeeExist(int eid);

	List<Employee> getEmployeeList();

	String getEmplayeName(int eid);

	Employee getEmplaye(int eid);
}
