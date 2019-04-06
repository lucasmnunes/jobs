package com.poll.api.mock;

import static java.util.Collections.singletonList;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.poll.api.dto.PollSessionDTO;
import com.poll.api.entity.PollSession;

public abstract class PollSessionMocker {
	
	public static final Long ID = 40L;
	
	public static LocalDateTime DATE = LocalDateTime.now(Clock.tick(Clock.systemDefaultZone(), Duration.ofHours(1)));
	
	public static final PollSession ENTITY = PollSession.builder()
			.id(ID)
			.poll(PollMocker.ENTITY)
			.startDate(DATE)
			.endDate(DATE.plusSeconds(60))
			.build();
	
	public static final PollSession ENTITY_OPEN = PollSession.builder()
			.id(ID)
			.poll(PollMocker.ENTITY)
			.startDate(DATE)
			.endDate(LocalDateTime.now().plusMonths(1))
			.build();
	
	public static final PollSession ENTITY_EXPIRED = PollSession.builder()
			.id(ID)
			.poll(PollMocker.ENTITY)
			.startDate(DATE)
			.endDate(LocalDateTime.now().minusSeconds(1))
			.build();
	
	public static final PollSessionDTO DTO = PollSessionDTO.valueOf(ENTITY);
	
	public static final Optional<PollSession> ENTITY_OPTIONAL = Optional.of(ENTITY);
	
	public static final List<PollSession> LIST = singletonList(ENTITY);
	
}
