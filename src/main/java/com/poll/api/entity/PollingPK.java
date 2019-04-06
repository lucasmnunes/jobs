package com.poll.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PollingPK implements Serializable {

	private static final long serialVersionUID = -9161578665213142331L;

	@Column(name = "poll_session_id", nullable = false)
    Long pollSessionId;
 
    @Column(name = "user_id", nullable = false)
    Long userId;
	
}
