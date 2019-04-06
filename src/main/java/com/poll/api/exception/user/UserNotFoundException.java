package com.poll.api.exception.user;

import com.poll.api.exception.ResourceNotFoundException;

public class UserNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 235038467587008984L;

	public UserNotFoundException(Long id) {
		super(String.format("User #%d not found", id));
	}

}
