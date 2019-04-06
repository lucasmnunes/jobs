package com.poll.api.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.poll.api.model.VoteOption;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_polling")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Polling implements Serializable {

	private static final long serialVersionUID = -5748941092324400774L;

	@EmbeddedId
	PollingPK id;
	
	@ManyToOne
	@MapsId("poll_session_id")
    @JoinColumn(name = "poll_session_id")
    private PollSession pollSession;
 
    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(nullable = false)
    private LocalDateTime date;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VoteOption vote;

}
