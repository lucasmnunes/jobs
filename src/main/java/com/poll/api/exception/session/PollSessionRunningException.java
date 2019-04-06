package com.poll.api.exception.session;

import com.poll.api.entity.PollSession;
import com.poll.api.exception.BusinessException;

public class PollSessionRunningException extends BusinessException {

	private static final long serialVersionUID = 2424512752222016942L;

	public PollSessionRunningException(PollSession pollSession) {
		super(String.format("Poll Session #%d is running. Unable to show results", pollSession.getId()));
	}

}
