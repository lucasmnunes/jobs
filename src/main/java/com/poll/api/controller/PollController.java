package com.poll.api.controller;

import static java.util.stream.Collectors.toList;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poll.api.dto.PollDTO;
import com.poll.api.exception.BusinessException;
import com.poll.api.service.PollService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/polls")
@CrossOrigin(origins = "*")
class PollController {

	private final PollService service;

	@Autowired
	PollController(PollService service) {
		this.service = service;
	}

	@GetMapping
	@ApiOperation(value = "Return all Polls")
	ResponseEntity<List<PollDTO>> findAll() {
		return new ResponseEntity<>(service.findAll()
				.stream()
				.map(PollDTO::valueOf)
				.collect(toList()), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Return a specific Poll by ID")
	ResponseEntity<PollDTO> findById(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<>(PollDTO.valueOf(service.findById(id)), HttpStatus.OK);
	}

	@ApiOperation(value = "Save a Poll")
	@PostMapping
	ResponseEntity<PollDTO> save(@Valid @RequestBody PollDTO pollDTO, Errors errors) {
		if (errors.hasErrors()) {
			throw new BusinessException(errors.toString());
		}
		return new ResponseEntity<>(PollDTO.valueOf(service.save(pollDTO)), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Delete a Poll")
	@DeleteMapping("/{id}")
	ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}
