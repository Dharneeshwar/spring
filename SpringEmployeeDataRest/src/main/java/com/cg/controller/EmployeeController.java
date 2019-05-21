package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.beans.Employee;
import com.cg.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	Employee employee;

	@PostMapping("/add/{name}/{address}/{salary}/{designation}")
	public Employee addemployee(@PathVariable String name, @PathVariable String address, @PathVariable Double salary,
			@PathVariable String designation) {
		employee.setName(name);
		employee.setAddress(address);
		employee.setSalary(salary);
		employee.setDesignation(designation);

		Employee savedEmp = employeeService.addEmployee(employee);
		return savedEmp;
	}

//post
	// http://localhost:8083/add/......
	@PostMapping(value = "/addobject", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Employee addEmpObject(@RequestBody Employee employee) {
		Employee savedEmp = employeeService.addEmployee(employee);
		return savedEmp;

	}

	// GET
	// http://localhost:8083/viewall
	@GetMapping("/viewall")
	public List<Employee> viewAll() {
		return employeeService.getEmployee();
	}
	// GET
	// http://localhost:8083/viewaddress?address=

	@GetMapping("/viewaddress")
	public List<Employee> viewaddress(@RequestParam String address) {
		return employeeService.getEmployeeByAddress(address);
	}

	// GET
	// http://localhost:8083/viewaddress/chennai
	@GetMapping("/viewaddress/{address}")
	public List<Employee> viewAddressPath(@PathVariable String address) {
		return employeeService.getEmployeeByAddress(address);
	}

	// GET
	// http://localhost:8083/viewdesignation?designation =
	@GetMapping("/viewdesignation")
	public List<Employee> viewDesignation(@RequestParam String designation) {
		return employeeService.getEmployeeByDesignation(designation);
	}

	// GET
	// http://localhost:8083/viewdesignation/trainee
	@GetMapping("/viewdesignation/{designation}")
	public List<Employee> viewDesignationPath(@PathVariable String designation) {
		return employeeService.getEmployeeByDesignation(designation);
	}

	// delete
	// htyp://localhost:8083/deletbyid/ ""
	@RequestMapping("/deletebyid/{empId}")
	public String deleteById(@PathVariable Integer empId) {
		employeeService.deleteById(empId);
		return empId + "deleted";
	}

	// delete
	// htyp://localhost:8083/deleteall
	@RequestMapping("/deleteall")
	public void deleteAll() {
		employeeService.deletAll();
	}

	// Get
	// http;//localhost:8083/findbyid/3001
	@GetMapping("/findbyid/{empId}")
	public Employee findById(@PathVariable Integer empId) {
		return employeeService.findById(empId);
	}

	// Get
	// http;//localhost:8083/salaryrange/10000/80000
	@GetMapping("/salaryrange/{salary1}/{salary2}")
	public List<Employee> salaryRange(@PathVariable Double salary1, @PathVariable Double salary2) {
		return employeeService.salaryRange(salary1, salary2);
	}

//put
	// http://localhost:8083/update / send complete json
	@PutMapping(value = "/updateobject", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Employee updateObject(@RequestBody Employee employee) {
		Employee updatedEmp = employeeService.updateEmployee(employee);
		return updatedEmp;

	}
	/*
	 * @ResponseStatus(value=HttpStatus.NOT_FOUND , reason =
	 * "Invalid request - Employee id not present")
	 * 
	 * @ExceptionHandler({Exception.class}) public void handleException() { }
	 */

}

