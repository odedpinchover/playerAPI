package com.example.demo.exceptions;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
class GlobalDefaultExceptionHandler
{
	@ExceptionHandler
	public String defaultErrorHandler(HttpServletRequest req, Exception e)
	{

		if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
			return e.getMessage();

		return "generic error msg for yet to be handle exceptions";// should not get here tho, we should handle all errors
	}
}
