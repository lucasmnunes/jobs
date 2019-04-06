package com.poll.api.exception.poll;

import com.poll.api.exception.BusinessException;

public class PollAlreadyExistsException extends BusinessException {

	private static final long serialVersionUID = 7967073173402618065L;

	public PollAlreadyExistsException(String pollName) {
		super(String.format("Poll '%s' has already been created", pollName));
	}	

}
