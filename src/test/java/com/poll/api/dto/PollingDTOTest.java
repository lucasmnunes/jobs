package com.poll.api.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.poll.api.entity.Polling;
import com.poll.api.mock.PollingMocker;

public class PollingDTOTest {
	
	@Test
	public void givenPolling_whenValueOf_thenReturnPollingDTO() {
		Polling pollingMocker = PollingMocker.ENTITY;
		PollingDTO pollingDTO = PollingDTO.valueOf(pollingMocker);
		assertNotNull(pollingDTO);
		assertEquals(pollingMocker.getPollSession().getId(), pollingDTO.getPollSessionId());
		assertEquals(pollingMocker.getUser().getId(), pollingDTO.getUserId());
		assertEquals(pollingMocker.getVote(), pollingDTO.getVote());
	}
	
}
