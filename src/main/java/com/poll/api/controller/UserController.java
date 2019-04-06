package com.poll.api.controller;

import static java.util.stream.Collectors.toList;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poll.api.dto.UserDTO;
import com.poll.api.exception.BusinessException;
import com.poll.api.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/users")
class UserController {

	private final UserService service;

	@Autowired
	UserController(UserService service) {
		this.service = service;
	}

	@GetMapping
	@ApiOperation(value = "Return all Users")
	ResponseEntity<List<UserDTO>> findAll() {
		return new ResponseEntity<>(service.findAll()
				.stream()
				.map(UserDTO::valueOf)
				.collect(toList()), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Return a specific User by ID")
	ResponseEntity<UserDTO> findById(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<>(UserDTO.valueOf(service.findById(id)), HttpStatus.OK);
	}
	
	@PostMapping
	@ApiOperation(value = "Save an User")
	ResponseEntity<UserDTO> save(@Valid @RequestBody UserDTO userDTO, Errors errors) {
		if (errors.hasErrors()) {
	        throw new BusinessException(errors.toString());
		}
		return new ResponseEntity<>(UserDTO.valueOf(service.save(userDTO)), HttpStatus.CREATED);
	}

}
