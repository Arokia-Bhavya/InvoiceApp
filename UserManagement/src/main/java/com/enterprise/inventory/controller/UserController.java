package com.enterprise.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.inventory.domain.User;
import com.enterprise.inventory.repository.UserRepository;

@RestController
@RequestMapping("/enterprise-app/user")
public class UserController {
	@Autowired
	UserRepository userRepo;
	
	
	@PostMapping("")
	User createUser(@RequestBody User user)
	{
		user=userRepo.save(user);
		return user;
	}
}
