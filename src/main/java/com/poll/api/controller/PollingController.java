package com.poll.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poll.api.dto.PollingDTO;
import com.poll.api.dto.request.PollingVoteRequestDTO;
import com.poll.api.exception.BusinessException;
import com.poll.api.service.PollingService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/pollings")
@CrossOrigin(origins = "*")
class PollingController {

	private final PollingService service;

	@Autowired
	PollingController(PollingService service) {
		this.service = service;
	}

	@PostMapping
	@ApiOperation(value = "Save a Polling")
	ResponseEntity<PollingDTO> save(@Valid @RequestBody PollingVoteRequestDTO pollingVoteRequestDTO, Errors errors) {
		if (errors.hasErrors()) {
			throw new BusinessException(errors.toString());
		}
		return new ResponseEntity<>(service.save(pollingVoteRequestDTO), HttpStatus.CREATED);
	}

}
