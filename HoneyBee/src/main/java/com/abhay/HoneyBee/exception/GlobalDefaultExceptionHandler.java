package com.abhay.HoneyBee.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle","The page is not constructed!");
		mv.addObject("errorDescription","The page is not available for view!");
		mv.addObject("title","404 Error Page");

		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle","Product is not available!");
		mv.addObject("errorDescription","The requested product is not available currently!");
		mv.addObject("title","404 Error Page");

		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception e) {
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle","Contact the Administrator!");
		
		/* Only for debugging "*/
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		e.printStackTrace(pw);
		
		mv.addObject("errorDescription",sw.toString());
		mv.addObject("title","Error");

		return mv;
	}
}
