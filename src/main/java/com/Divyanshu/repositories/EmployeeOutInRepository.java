package com.Divyanshu.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Divyanshu.models.EmployeeOutIn;

public interface EmployeeOutInRepository extends JpaRepository<EmployeeOutIn,Integer> 
{
	@Query("select count(*) from EmployeeOutIn e where eid=:arg1 and date=:arg2 and intime=:arg3")
	int getInTime(@Param("arg1") int eid,@Param("arg2") String date,@Param("arg3") String intime);
	@Transactional
	@Modifying
	@Query("update EmployeeOutIn set intime=:arg1,totaltime=:arg2 where eid=:arg3 and date=:arg4")
	void updateIntime(@Param("arg1") String intime,@Param("arg2") String totaltime,@Param("arg3") int eid,@Param("arg4") String date);
	@Query("from EmployeeOutIn e where eid=:arg1 and date=:arg2 and intime=:arg3")
	EmployeeOutIn getOutInTime(@Param("arg1") int eid,@Param("arg2") String date,@Param("arg3") String intime);
}
