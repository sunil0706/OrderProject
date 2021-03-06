package com.orderdetail.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException {

	static final long serialVersionUID = 1L;

	public OrderNotFoundException(String message) {
		super(message);
	}

	public OrderNotFoundException() {
	}
}
