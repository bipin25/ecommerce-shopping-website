package com.onlineshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(ItemNotFoundException.class)
	public ModelAndView handlerItemNotFound(ItemNotFoundException e) {
		e.printStackTrace();
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("errorMessage", e.getMessage());
		mav.addObject("httpStatus", HttpStatus.NOT_FOUND);
		mav.addObject("errorDescription", "Items You are looking for is not available");
		return mav;
	}
	
	/*@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFound(NoHandlerFoundException e) {
		e.printStackTrace();
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("errorMessage", "The Page is not Constructed");
		mav.addObject("httpStatus", HttpStatus.NOT_FOUND);
		mav.addObject("errorDescription", "The Page you are looking for is not available");
		return mav;
	}*/
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerItemNotFound(Exception e) {
		e.printStackTrace();
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("httpStatus", HttpStatus.INTERNAL_SERVER_ERROR);
		mav.addObject("errorMessage", e.getLocalizedMessage());
		mav.addObject("errorDescription",e.toString());
		return mav;
	}
	
}
