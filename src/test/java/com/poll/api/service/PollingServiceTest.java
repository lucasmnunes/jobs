package com.poll.api.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.poll.api.entity.Polling;
import com.poll.api.exception.session.PollSessionExpiredException;
import com.poll.api.mock.PollMocker;
import com.poll.api.mock.PollSessionMocker;
import com.poll.api.mock.PollingMocker;
import com.poll.api.mock.PollingVoteRequestMocker;
import com.poll.api.mock.UserMocker;
import com.poll.api.repository.PollingRepository;

@RunWith(SpringRunner.class)
public class PollingServiceTest {

	@InjectMocks
	private PollingService service;

	@Mock
	private PollingRepository repository;

	@Mock
	private PollService pollService;
	
	@Mock
	private PollSessionService pollSessionService;

	@Mock
	private UserService userService;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Before
	public void setUp() {
		when(repository.save(any(Polling.class))).thenReturn(PollingMocker.ENTITY);
		when(pollSessionService.findById(PollSessionMocker.ID)).thenReturn(PollSessionMocker.ENTITY);
		when(userService.findById(UserMocker.ID)).thenReturn(UserMocker.ENTITY);
		when(pollService.findById(PollMocker.ID)).thenReturn(PollMocker.ENTITY);
	}

	@Test
	public void givenPollSessionId_whenFindByPollSession_thenCallRepositoryOnce() {
		service.findByPollSession(PollSessionMocker.ID);
		verify(repository, times(1)).findByPollSessionId(PollSessionMocker.ID);
	}

	@Test(expected = PollSessionExpiredException.class)
	public void givenPolling_whenSave_thenCallRepositoryAndReturnPolling() {
		when(pollSessionService.findById(PollSessionMocker.ID)).thenReturn(PollSessionMocker.ENTITY_EXPIRED);
		service.save(PollingVoteRequestMocker.DTO);
	}

}
