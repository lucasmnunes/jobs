package com.poll.api.mock;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;

import com.poll.api.entity.Polling;
import com.poll.api.model.VoteOption;

public abstract class PollingMocker {
	
	public static final Long ID = 50L;
	
	public static final String NAME = "User Name";
	
	public static final String LOGIN = "User Login";
	
	public static final VoteOption VOTE = VoteOption.YES;
	
	public static LocalDateTime DATE = LocalDateTime.now(Clock.tick(Clock.systemDefaultZone(), Duration.ofHours(1)));
	
	public static final Polling ENTITY = Polling.builder()
			.pollSession(PollSessionMocker.ENTITY)
			.user(UserMocker.ENTITY)
			.date(DATE)
			.vote(VOTE)
			.build();
	
}
