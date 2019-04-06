package com.poll.api.exception.polling;

import com.poll.api.entity.Polling;
import com.poll.api.exception.BusinessException;

public class UserAlreadyVotedInPollSessionException extends BusinessException {

	private static final long serialVersionUID = 2570664460005654751L;

	public UserAlreadyVotedInPollSessionException(Polling polling) {
		super(String.format("User #%d already voted in Poll Session #%d", polling.getUser().getId(),
				polling.getPollSession().getId()));
	}

}
