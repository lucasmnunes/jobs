package com.poll.api.exception.poll;

import com.poll.api.exception.ResourceNotFoundException;

public class PollNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 7882173702298184228L;

	public PollNotFoundException(Long id) {
		super(String.format("Poll #%d not found", id));
	}

}
