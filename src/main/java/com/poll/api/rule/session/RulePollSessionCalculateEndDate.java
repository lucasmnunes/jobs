package com.poll.api.rule.session;

import java.time.LocalDateTime;
import java.util.Optional;

import com.poll.api.dto.request.PollSessionRequestDTO;

public class RulePollSessionCalculateEndDate {
	
	private static final int POLL_DEFAULT_DURATION_IN_SECONDS = 60;
	
	private RulePollSessionCalculateEndDate() {
	    throw new IllegalStateException("Rule utility class");
	}

	public static LocalDateTime process(PollSessionRequestDTO pollSessionRequestDTO, LocalDateTime startDate) {
		return startDate.plusSeconds(Optional
				.ofNullable(pollSessionRequestDTO.getDuration())
				.orElse(POLL_DEFAULT_DURATION_IN_SECONDS));
	}
}