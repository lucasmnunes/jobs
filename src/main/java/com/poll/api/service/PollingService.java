package com.poll.api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poll.api.dto.PollingDTO;
import com.poll.api.dto.request.PollingVoteRequestDTO;
import com.poll.api.entity.PollSession;
import com.poll.api.entity.Polling;
import com.poll.api.entity.PollingPK;
import com.poll.api.entity.User;
import com.poll.api.model.VoteOption;
import com.poll.api.repository.PollingRepository;
import com.poll.api.rule.session.RuleCheckPollSessionIsExpired;
import com.poll.api.rule.session.RuleCheckUserAlreadyVotedInPollSession;

@Service
public class PollingService {

	private final PollingRepository repository;	
	private final PollSessionService pollSessionService;
	private final UserService userService;

	@Autowired
	public PollingService(PollingRepository repository, PollSessionService pollSessionService, UserService userService) {
		this.repository = repository;
		this.pollSessionService = pollSessionService;
		this.userService = userService; 
	}

	@Transactional(readOnly = true)
	public List<Polling> findByPollSession(Long pollSessionId) {
		return repository.findByPollSessionId(pollSessionId);
	}

	@Transactional(readOnly = false)
	public PollingDTO save(PollingVoteRequestDTO pollingVoteRequestDTO) {
		PollSession pollSession = pollSessionService.findById(pollingVoteRequestDTO.getPollSessionId());
		User user = userService.findById(pollingVoteRequestDTO.getUserId());
		
		RuleCheckPollSessionIsExpired.process(pollSession);
		RuleCheckUserAlreadyVotedInPollSession
				.process(repository.findByPollSessionIdAndUserId(pollSession.getId(), user.getId()));
		
		return PollingDTO.valueOf(repository.save(createPolling(pollSession, user, pollingVoteRequestDTO.getVote())));
	}

	private Polling createPolling(PollSession pollSession, User user, VoteOption vote) {
		return Polling.builder()
				.id(createPollingPK(pollSession, user))
				.pollSession(pollSession)
				.user(user)
				.date(LocalDateTime.now())
				.vote(vote)
				.build();
	}

	private PollingPK createPollingPK(PollSession pollSession, User user) {
		return PollingPK.builder()
				.pollSessionId(pollSession.getId())
				.userId(user.getId())
				.build();
	}
	
}
