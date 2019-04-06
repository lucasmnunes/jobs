package com.poll.api.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.poll.api.entity.PollSession;
import com.poll.api.mock.PollSessionMocker;

public class PollSessionDTOTest {
	
	@Test
	public void givenPollSession_whenValueOf_thenReturnPollSessionDTO() {
		PollSession pollSessionMocker = PollSessionMocker.ENTITY;
		PollSessionDTO pollSessionDTO = PollSessionDTO.valueOf(pollSessionMocker);
		assertNotNull(pollSessionDTO);
		assertEquals(pollSessionMocker.getId(), pollSessionDTO.getId());
		assertEquals(pollSessionMocker.getPoll().getId(), pollSessionDTO.getPollDTO().getId());
		assertEquals(pollSessionMocker.getStartDate(), pollSessionDTO.getStartDate());
		assertEquals(pollSessionMocker.getEndDate(), pollSessionDTO.getEndDate());
	}
	
}
