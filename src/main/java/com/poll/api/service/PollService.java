package com.poll.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poll.api.dto.PollDTO;
import com.poll.api.entity.Poll;
import com.poll.api.exception.poll.PollNotFoundException;
import com.poll.api.repository.PollRepository;
import com.poll.api.rule.poll.RuleCheckIsPossibleDeletePoll;
import com.poll.api.rule.poll.RuleCheckPollExists;

@Service
public class PollService {

	private final PollRepository repository;
	
	private PollSessionService pollSessionService;
	
	@Autowired
	public PollService(PollRepository repository) {
		this.repository = repository;
	}
	
	@Autowired
	public void setPollSessionService(PollSessionService pollSessionService) {
		this.pollSessionService = pollSessionService;
	}

	public List<Poll> findAll() {
		return repository.findAll();
	}

	public Poll findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new PollNotFoundException(id));
	}
	
	public Poll save(PollDTO pollDTO) {
		RuleCheckPollExists.process(repository.findByName(pollDTO.getName()));
		return repository.save(createPoll(pollDTO));
	}

	private Poll createPoll(PollDTO pollDTO) {
		return Poll.builder()
				.name(pollDTO.getName())
				.description(pollDTO.getDescription())
				.build();
	}
	
	public void deleteById(Long id) {
		Poll poll = findById(id);
		RuleCheckIsPossibleDeletePoll.process(poll, pollSessionService.findByPoll(id));
		repository.delete(poll);
	}
	
}
