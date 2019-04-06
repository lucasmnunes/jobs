package com.poll.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poll.api.entity.Polling;
import com.poll.api.entity.PollingPK;

@Repository
public interface PollingRepository extends JpaRepository<Polling, PollingPK> {

	List<Polling> findByPollSessionId(Long pollSessionId);

	Polling findByPollSessionIdAndUserId(Long pollSessionId, Long userId);

}
