package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	
	@Autowired
	private UserService service;
	
	
	@PostMapping("/api/registeruser")
	//@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception{
	
		String tempEmailId= user.getEmail();
		if(tempEmailId != null && !"".equals(tempEmailId)){
			User userobj= service.fetchUserByEmail(tempEmailId);
			if(userobj != null){
				throw new Exception("user is already exist");
			}
		}
		
		User userObj = null;
		userObj = service.saveUser(user);
		return userObj;
	}
	
	
	@PostMapping("/api/login")
	//@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception{
	
		String tempEmailId= user.getEmail();
		String tempPass= user.getPassword();
		User userObj=null;
		
		if(tempEmailId != null && tempPass != null){
			userObj=service.fetchUserByEmailAndPassword(tempEmailId,tempPass);
		}
		if(userObj==null){
		throw new Exception("bad credentials");
		}
		return userObj;
		
	}
	
	@GetMapping("/api/get")
	//@CrossOrigin(origins = "http://localhost:4200")
	public User getUser(@RequestBody User user) throws Exception{
	
	
		return user;
	}
	
	
	
}


