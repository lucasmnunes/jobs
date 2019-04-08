package com.poll.api.controller;

import static java.util.stream.Collectors.toList;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poll.api.dto.PollSessionDTO;
import com.poll.api.dto.request.PollSessionRequestDTO;
import com.poll.api.dto.response.PollSessionResultDTO;
import com.poll.api.exception.BusinessException;
import com.poll.api.service.PollSessionService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/sessions")
@CrossOrigin(origins = "*")
class PollSessionController {

	private final PollSessionService service;

	@Autowired
	PollSessionController(PollSessionService service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Return a specific Poll Session")
	ResponseEntity<PollSessionDTO> findById(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<>(PollSessionDTO.valueOf(service.findById(id)), HttpStatus.OK);
	}
	
	@GetMapping("/poll/{id}")
	@ApiOperation(value = "Return all Poll Sessions by a specific Poll")
	ResponseEntity<List<PollSessionDTO>> findByPoll(@PathVariable(value = "id") Long pollId) {
		return new ResponseEntity<>(service.findByPoll(pollId)
				.stream()
				.map(PollSessionDTO::valueOf)
				.collect(toList()), HttpStatus.OK);
	}
	
	@GetMapping("/{id}/details")
	@ApiOperation(value = "Return the complete result of a specific Poll Session")
	ResponseEntity<PollSessionResultDTO> findPollSessionDetailsById(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<>(service.findPollSessionDetailsById(id), HttpStatus.OK);
	}

	@ApiOperation(value = "Save a Poll Session")
	@PostMapping
	ResponseEntity<PollSessionDTO> save(@Valid @RequestBody PollSessionRequestDTO pollSessionRequestDTO,
			Errors errors) {
		if (errors.hasErrors()) {
	        throw new BusinessException(errors.toString());
		}
		return new ResponseEntity<>(PollSessionDTO.valueOf(service.save(pollSessionRequestDTO)), HttpStatus.CREATED);
	}

}
