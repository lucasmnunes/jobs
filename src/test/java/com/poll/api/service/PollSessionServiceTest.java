package com.poll.api.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.poll.api.entity.PollSession;
import com.poll.api.mock.PollMocker;
import com.poll.api.mock.PollSessionMocker;
import com.poll.api.mock.PollSessionRequestMocker;
import com.poll.api.repository.PollSessionRepository;

@RunWith(SpringRunner.class)
public class PollSessionServiceTest {
	
	@InjectMocks
	private PollSessionService service;
	
	@Mock
	private PollSessionRepository repository;
	
	@Mock
	private PollService pollService;
	
	@Before
    public void setUp() {
        when(repository.findById(PollSessionMocker.ID)).thenReturn(PollSessionMocker.ENTITY_OPTIONAL);
        when(repository.findByPollId(PollMocker.ID)).thenReturn(PollSessionMocker.LIST);
        when(repository.save(any(PollSession.class))).thenReturn(PollSessionMocker.ENTITY);
        when(pollService.findById(PollMocker.ID)).thenReturn(PollMocker.ENTITY);
    }
	
	@Test
	public void givenPollSessionId_whenFindById_thenCallRepositoryOnce() {
		service.findById(PollSessionMocker.ID);    	
		verify(repository, times(1)).findById(PollSessionMocker.ID);
	}
	
	@Test
	public void givenPollId_whenFindByPollId_thenCallRepositoryOnce() {
		service.findByPoll(PollSessionMocker.ID);    	
		verify(repository, times(2)).findByPollId(PollMocker.ID);
	}
	
	@Test
	public void givenPoll_whenSave_thenCallRepositoryAndReturnPoll() {
		service.save(PollSessionRequestMocker.DTO);    	
		assertEquals(new Long(40L), repository.save(PollSessionMocker.ENTITY).getId());
	}
	
}
