package com.poll.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poll.api.entity.PollSession;

@Repository
public interface PollSessionRepository extends JpaRepository<PollSession, Long> {
	
	List<PollSession> findByPollId(Long pollId);

}
