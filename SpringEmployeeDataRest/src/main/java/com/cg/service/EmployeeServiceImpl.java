package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.beans.Employee;
import com.cg.dao.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Transactional
	@Override
	public Employee addEmployee(Employee e) {
		return employeeRepository.save(e);
	}

	@Override
	public void deleteById(Integer empId) {
		employeeRepository.deleteById(empId);
	}

	@Override
	public void deletAll() {
		employeeRepository.deleteAll();
	}

	@Override
	public List<Employee> getEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> getEmployeeByDesignation(String designation) {
		return employeeRepository.findByDesignation(designation);
	}

	@Override
	public List<Employee> getEmployeeByAddress(String address) {
		return employeeRepository.findByAddress(address);
	}

	@Override
	public Employee findById(Integer empId) {
		return employeeRepository.findById(empId).get();
	}

	@Override
	public Employee updateEmployee(Employee e) {
		return employeeRepository.save(e);
	}

	@Override
	public List<Employee> salaryRange(Double salary1, Double salary2){
		
		return employeeRepository.listBysalaryRange(salary1 ,salary2);
	}

}
