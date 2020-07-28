package com.anusha.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Controller
public class GlobalExceptionHandlerMethods {
    
	
	@ExceptionHandler(value = Exception.class)
	public String handleGenericException(Exception e) {
		System.out.println("UnKnown Exception Occured : " + e);

		return "GenericException";
	}
}
