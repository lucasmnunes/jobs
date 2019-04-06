package com.poll.api.mock;

import com.poll.api.dto.request.PollSessionRequestDTO;

public abstract class PollSessionRequestMocker {
	
	public static final int DURATION = 3600;
	
	public static final PollSessionRequestDTO DTO = PollSessionRequestDTO.builder()
			.pollId(PollMocker.ID)
			.duration(DURATION)
			.build();
	
	public static final PollSessionRequestDTO DTO_WITH_NO_DURATION = PollSessionRequestDTO.builder()
			.pollId(PollMocker.ID)
			.build();
			
}
