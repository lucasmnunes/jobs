package com.poll.api.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_poll_session")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PollSession implements Serializable {

	private static final long serialVersionUID = 4219182385066785348L;

	@Id
	@Column(name = "poll_session_id", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "poll_session_sequence")
	@SequenceGenerator(name="poll_session_sequence", sequenceName = "poll_session_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "poll_id")
	private Poll poll;
	
	@Column(nullable = false)
	private LocalDateTime startDate;
	
	@Column(nullable = false)
	private LocalDateTime endDate;
}
