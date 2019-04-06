package com.poll.api.rule.session;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.Test;

import com.poll.api.dto.request.PollSessionRequestDTO;
import com.poll.api.mock.PollSessionRequestMocker;

public class RulePollSessionCalculateEndDateTest {
	
	private static final int POLL_SESSION_DEFAULT_DURATION_IN_SECONDS = 60;
	
	@Test
	public void givenPollSessionHasNoDuration_whenRulePollSessionCalculateEndDate_thenEndDateIsPlusSixtySeconds() {
		LocalDateTime startDate = LocalDateTime.now();
		LocalDateTime endDate = RulePollSessionCalculateEndDate
				.process(PollSessionRequestMocker.DTO_WITH_NO_DURATION, startDate);
		assertEquals(POLL_SESSION_DEFAULT_DURATION_IN_SECONDS, Duration.between(startDate, endDate).toMillis() / 1000);
	}
	
	@Test
	public void givenPollSessionHasDuration_whenRulePollSessionCalculateEndDate_thenEndDateIsPlusPollSessionDuration() {
		PollSessionRequestDTO pollSessionRequestDTOMock = PollSessionRequestMocker.DTO;
		int pollSessionRequestDuration = pollSessionRequestDTOMock.getDuration();
		
		LocalDateTime startDate = LocalDateTime.now();
		LocalDateTime endDate = RulePollSessionCalculateEndDate.process(pollSessionRequestDTOMock, startDate);
		
		assertEquals(pollSessionRequestDuration, Duration.between(startDate, endDate).toMillis() / 1000);
	}
}