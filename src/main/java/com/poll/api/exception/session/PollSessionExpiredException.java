package com.poll.api.exception.session;

import com.poll.api.entity.PollSession;
import com.poll.api.exception.BusinessException;

public class PollSessionExpiredException extends BusinessException {
 
	private static final long serialVersionUID = -7250779256777657002L;

	public PollSessionExpiredException(PollSession pollSession) {
		super(String.format("Poll Session #%d is expired", pollSession.getId()));
	}

}
