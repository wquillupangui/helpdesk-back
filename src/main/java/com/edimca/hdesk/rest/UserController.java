package com.edimca.hdesk.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edimca.hdesk.model.User;
import com.edimca.hdesk.repo.UserRepo;

@RestController
@CrossOrigin(origins = { "*" }, allowCredentials = "true")
@RequestMapping(path="/user")
public class UserController {
	
	public static final String USER_ROLE="TECH";
	
	@Autowired
	private UserRepo userRepo;

	@GetMapping(path="/list")
	public List<User> getAll(){
		return userRepo.findAll();
	}
	
	@GetMapping(path="/tech")
	public List<User> getAllTech(){
		return userRepo.findByRole(UserController.USER_ROLE);
	}
}
