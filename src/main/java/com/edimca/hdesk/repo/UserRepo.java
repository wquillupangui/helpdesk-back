package com.edimca.hdesk.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edimca.hdesk.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByName(String name);
	
	public List<User> findByRole(String role);
	
}
