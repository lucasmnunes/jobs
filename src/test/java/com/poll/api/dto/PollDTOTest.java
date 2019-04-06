package com.poll.api.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.poll.api.entity.Poll;
import com.poll.api.mock.PollMocker;

public class PollDTOTest {
	
	@Test
	public void givenPoll_whenValueOf_thenReturnPollDTO() {
		Poll pollMocker = PollMocker.ENTITY;
		PollDTO pollDTO = PollDTO.valueOf(pollMocker);
		assertNotNull(pollDTO);
		assertEquals(pollMocker.getId(), pollDTO.getId());
		assertEquals(pollMocker.getName(), pollDTO.getName());
		assertEquals(pollMocker.getDescription(), pollDTO.getDescription());
	}
	
	@Test
	public void givenPollDTO_whenToEntity_thenReturnPoll() {
		PollDTO pollDTOMocker = PollMocker.DTO;
		Poll poll = pollDTOMocker.toEntity();
		assertNotNull(poll);
		assertEquals(pollDTOMocker.getId(), poll.getId());
		assertEquals(pollDTOMocker.getName(), poll.getName());
		assertEquals(pollDTOMocker.getDescription(), poll.getDescription());
	}
	
}
