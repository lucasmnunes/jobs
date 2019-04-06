package com.poll.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poll.api.entity.Poll;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {

	Poll findByName(String name);
	
}
