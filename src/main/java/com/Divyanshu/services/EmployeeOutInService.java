package com.Divyanshu.services;

import com.Divyanshu.models.EmployeeOutIn;

public interface EmployeeOutInService 
{
	boolean saveOuttime(EmployeeOutIn outtime);
	boolean updateIntime(int eid);
}
