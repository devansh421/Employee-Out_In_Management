package com.Divyanshu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Divyanshu.models.EmployeeOutIn;

public interface EmpwiseReportRepository extends JpaRepository<EmployeeOutIn,Integer> 
{
	@Query("from EmployeeOutIn where eid=:id and date=:dt")
	List<EmployeeOutIn> findByDate(@Param("id") int eid,@Param("dt") String date);
	
	@Query("from EmployeeOutIn where eid=:id and date between :dt1 and :dt2")
	List<EmployeeOutIn> findDateBetweenList(@Param("id") int eid,@Param("dt1") String date1,@Param("dt2") String date2);
}
