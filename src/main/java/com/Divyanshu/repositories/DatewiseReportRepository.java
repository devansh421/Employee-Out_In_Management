package com.Divyanshu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Divyanshu.models.EmployeeOutIn;

public interface DatewiseReportRepository extends JpaRepository<EmployeeOutIn,Integer> 
{
	List<EmployeeOutIn> findByDate(String date);
	
	@Query("from EmployeeOutIn where date between :dt1 and :dt2")
	List<EmployeeOutIn> findDateBetweenList(@Param("dt1") String date1,@Param("dt2") String date2);
}
