package com.poll.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poll.api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByLogin(String login);
	
}
