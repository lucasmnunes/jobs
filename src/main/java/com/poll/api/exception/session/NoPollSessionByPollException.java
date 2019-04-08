package com.poll.api.exception.session;

import com.poll.api.exception.ResourceNotFoundException;

public class NoPollSessionByPollException extends ResourceNotFoundException {

	private static final long serialVersionUID = 2424512752222016942L;

	public NoPollSessionByPollException(Long pollId) {
		super(String.format("There is(are) no Poll Session(s) of Poll #%d", pollId));
	}

}
