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

import com.poll.api.entity.Poll;
import com.poll.api.mock.PollMocker;
import com.poll.api.mock.PollSessionMocker;
import com.poll.api.repository.PollRepository;
import com.poll.api.repository.PollSessionRepository;

@RunWith(SpringRunner.class)
public class PollServiceTest {
	
	@InjectMocks
	private PollService service;
	
	@Mock
	private PollRepository repository;
	
	@Mock
	private PollSessionService pollSessionService;
	

	@Mock
	private PollSessionRepository pollSessionRepository;
	
	@Before
    public void setUp() {
        when(repository.findById(PollMocker.ID)).thenReturn(PollMocker.ENTITY_OPTIONAL);
        when(repository.save(any(Poll.class))).thenReturn(PollMocker.ENTITY);
        when(pollSessionRepository.findByPollId(PollMocker.ID)).thenReturn(PollSessionMocker.EMPTY_LIST);
    }
	
	@Test
	public void whenFindAll_thenCallRepositoryOnce() {
		service.findAll();    	
		verify(repository, times(1)).findAll();
	}
	
	@Test
	public void givenPollId_whenFindById_thenCallRepositoryOnce() {
		service.findById(PollMocker.ID);    	
		verify(repository, times(1)).findById(PollMocker.ID);
	}
	
	@Test
	public void givenPoll_whenSave_thenCallRepositoryAndReturnPoll() {
		service.save(PollMocker.DTO);    	
		assertEquals("Poll Name", repository.save(PollMocker.ENTITY).getName());
	}
	
	@Test
	public void givenPollId_whenDelete_thenCallRepositoryOnceAndPollSessionRepositoryOnce() {
		service.deleteById(PollMocker.ID);    	
		verify(repository, times(1)).delete(PollMocker.ENTITY);
		verify(pollSessionRepository, times(1)).findByPollId(PollMocker.ID);
	}
	
}
