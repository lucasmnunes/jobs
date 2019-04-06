package com.poll.api.exception.polling;

import com.poll.api.exception.BusinessException;

public class PollSessionExistsException extends BusinessException {

	private static final long serialVersionUID = 7967073173402618065L;

	public PollSessionExistsException(String pollName) {
		super(String.format("Poll Session '%s' has already been created", pollName));
	}	

}
