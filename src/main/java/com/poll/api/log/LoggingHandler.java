package com.poll.api.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.poll.api.dto.PollDTO;
import com.poll.api.dto.UserDTO;
import com.poll.api.dto.request.PollSessionRequestDTO;
import com.poll.api.dto.request.PollingVoteRequestDTO;

@Aspect
@Component
class LoggingHandler {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* com.poll.api.controller.*.*(..))")
	void beforeAdvice(JoinPoint joinPoint) {
		logger.info("Requesting... {}", joinPoint.getSignature());
	}
	
	@Before("execution(* com.poll.api.controller.*.*(..)) && args(pollDTO, errors)")
	void beforeAdvice(JoinPoint joinPoint, PollDTO pollDTO, Errors errors) {
		logger.info("Adding new Poll: '{}'...", pollDTO.getName());
	}
	
	@Before("execution(* com.poll.api.controller.*.*(..)) && args(pollSessionRequestDTO, errors)")
	void beforeAdvice(JoinPoint joinPoint, PollSessionRequestDTO pollSessionRequestDTO, Errors errors) {
		logger.info("Adding new Poll Session from Poll #{}...", pollSessionRequestDTO.getPollId());
	}
	
	@Before("execution(* com.poll.api.controller.*.*(..)) && args(pollingVoteRequestDTO, errors)")
	void beforeAdvice(JoinPoint joinPoint, PollingVoteRequestDTO pollingVoteRequestDTO, Errors errors) {
		logger.info("Adding new Polling (Poll Session: #{}, User: #{})...", 
				pollingVoteRequestDTO.getPollSessionId(), pollingVoteRequestDTO.getUserId());
	}
	
	@Before("execution(* com.poll.api.controller.*.*(..)) && args(userDTO, errors)")
	void beforeAdvice(JoinPoint joinPoint, UserDTO userDTO, Errors errors) {
		logger.info("Adding new User (User: '{}')...", userDTO.getLogin());
	}

}