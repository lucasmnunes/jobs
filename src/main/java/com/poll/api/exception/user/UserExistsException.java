package com.poll.api.exception.user;

import com.poll.api.exception.BusinessException;

public class UserExistsException extends BusinessException {

	private static final long serialVersionUID = -5065097397325745414L;

	public UserExistsException(String userName) {
		super(String.format("User '%s' has already been registered", userName));
	}

}
