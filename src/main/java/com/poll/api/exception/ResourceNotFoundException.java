package com.poll.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3325698913297233225L;

	public ResourceNotFoundException(String msg) {
		super(msg);
	}
	
}
