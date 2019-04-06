package com.poll.api.exception.poll;

import com.poll.api.exception.BusinessException;

public class PollDeleteException extends BusinessException {

	private static final long serialVersionUID = 7086042242128943325L;

	public PollDeleteException(Long pollId) {
		super(String.format("Poll #%d has Poll Sessions. It's not possible delete a Poll with associated sessions",
				pollId));
	}

}
