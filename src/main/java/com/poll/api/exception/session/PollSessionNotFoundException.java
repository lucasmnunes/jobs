package com.poll.api.exception.session;

import com.poll.api.exception.ResourceNotFoundException;

public class PollSessionNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 6630909434629295068L;

	public PollSessionNotFoundException(Long id) {
		super(String.format("Poll Session #%d not found", id));
	}

}
