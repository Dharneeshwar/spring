package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.beans.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer > {

	public List<Employee> findByDesignation(String designation);
	
	
	public List<Employee> findByAddress(String designation);

@Query("select e from Employee e where e.salary between ?1 and ?2")
	public List<Employee> listBysalaryRange(Double salary1 , Double salary2);
}


