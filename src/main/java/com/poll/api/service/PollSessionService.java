package com.poll.api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poll.api.dto.request.PollSessionRequestDTO;
import com.poll.api.dto.response.PollSessionResultDTO;
import com.poll.api.entity.Poll;
import com.poll.api.entity.PollSession;
import com.poll.api.exception.session.PollSessionNotFoundException;
import com.poll.api.repository.PollSessionRepository;
import com.poll.api.repository.PollingRepository;
import com.poll.api.rule.session.RuleCheckPollSessionIsRunning;
import com.poll.api.rule.session.RulePollSessionCalculateEndDate;

@Service
public class PollSessionService {

	private final PollSessionRepository repository;
	private final PollService pollService;
	private final PollSessionResultService pollSessionResultService;
	private final PollingRepository pollingRepository;
	
	@Autowired
	public PollSessionService(PollSessionRepository repository, PollService pollService,
			PollSessionResultService pollSessionResultService, PollingRepository pollingRepository) {
		this.repository = repository;
		this.pollService = pollService;
		this.pollSessionResultService = pollSessionResultService;
		this.pollingRepository = pollingRepository;
	}

	@Transactional(readOnly = true)
	public PollSession findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new PollSessionNotFoundException(id));
	}
	
	@Transactional(readOnly = true)
	public List<PollSession> findByPoll(Long pollId) {
		return repository.findByPollId(pollId);
	}
	
	@Transactional(readOnly = false)
	public PollSession save(PollSessionRequestDTO pollSessionRequestDTO) {
		Poll poll = pollService.findById(pollSessionRequestDTO.getPollId());
		return repository.save(createPollSession(poll, pollSessionRequestDTO));
	}

	@Transactional(readOnly = true)
	public PollSessionResultDTO findPollSessionDetailsById(Long id) {
		PollSession pollSession = findById(id);
		RuleCheckPollSessionIsRunning.process(pollSession);

		return pollSessionResultService
				.createPollSessionResult(pollSession, pollingRepository.findByPollSessionId(id));
	}
	
	private PollSession createPollSession(Poll poll, PollSessionRequestDTO pollSessionRequestDTO) {
		LocalDateTime now = LocalDateTime.now();
		
		return PollSession.builder()
				.poll(poll)
				.startDate(now)
				.endDate(RulePollSessionCalculateEndDate.process(pollSessionRequestDTO, now))
				.build();
	}
	
}
