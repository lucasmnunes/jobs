package com.poll.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_poll")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Poll implements Serializable {

	private static final long serialVersionUID = -2911124794414364422L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "poll_sequence")
	@SequenceGenerator(name="poll_sequence", sequenceName = "poll_seq")
	@Column(name = "poll_id", nullable = false, updatable = false)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String description;

}
