package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="element not found")  // 404
public class ElementNotFoundException extends RuntimeException {

	public ElementNotFoundException(){
		super("element not found exception - someone deleted this data");
	}
}
