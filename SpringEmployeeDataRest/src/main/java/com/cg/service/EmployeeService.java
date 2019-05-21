package com.cg.service;

import java.util.List;

import com.cg.beans.Employee;

public interface EmployeeService {

public Employee addEmployee(Employee e);

public void deleteById(Integer empId);

public void deletAll();
public List<Employee> getEmployee();
public List<Employee> getEmployeeByDesignation(String designation);
public List<Employee> getEmployeeByAddress(String address);
public Employee findById(Integer empId);
public Employee updateEmployee(Employee e);
public List<Employee> salaryRange(Double salary1 , Double salary2);
}
