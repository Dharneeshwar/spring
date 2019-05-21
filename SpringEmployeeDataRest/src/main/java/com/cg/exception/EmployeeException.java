package com.cg.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmployeeException {
@ResponseBody
@ResponseStatus(value = HttpStatus.NOT_FOUND)
@ExceptionHandler(value = {Exception.class})
	public ErrorInfo handleException(Exception ex ,HttpServletRequest request){
		String msg = ex.getMessage();
		String url = request.getRequestURL().toString();
		return new ErrorInfo(url ,msg);
	}
		

}
