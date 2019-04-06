package com.poll.api.exception.polling;

import com.poll.api.exception.ResourceNotFoundException;

public class PollingNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 3192663149325470453L;

	public PollingNotFoundException(Long id) {
		super(String.format("Polling #%d not found", id));
	}

}
