package com.poll.api.mock;

import com.poll.api.dto.request.PollingVoteRequestDTO;
import com.poll.api.model.VoteOption;

public abstract class PollingVoteRequestMocker {
	
	public static final VoteOption VOTE = VoteOption.YES;
	
	public static final PollingVoteRequestDTO DTO = PollingVoteRequestDTO.builder()
			.pollSessionId(PollSessionMocker.ID)
			.userId(UserMocker.ID)
			.vote(VOTE)
			.build();

}
