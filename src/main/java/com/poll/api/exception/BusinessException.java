package com.poll.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 4690375655497673286L;

	public BusinessException(String msg) {
		super(msg);
	}

}
