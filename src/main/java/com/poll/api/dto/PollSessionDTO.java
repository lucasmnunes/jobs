package com.poll.api.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.poll.api.entity.PollSession;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PollSessionDTO implements Serializable {
	
	private static final long serialVersionUID = -3429846795653645357L;
	
	private Long id;
	private PollDTO pollDTO;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	
	public static PollSessionDTO valueOf(PollSession pollSession) {
		return PollSessionDTO.builder()
				.id(pollSession.getId())
				.pollDTO(PollDTO.valueOf(pollSession.getPoll()))
				.startDate(pollSession.getStartDate())
				.endDate(pollSession.getEndDate())
				.build();
	}
	
}
