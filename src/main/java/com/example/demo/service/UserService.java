package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService   {

	@Autowired
	private UserRepository repo;
	
	public User saveUser(User user){	
		return repo.save(user);
	}
	
	
	/* OJO es finById(object) pero quito el id y le puso el nombre que el queria
		ya con esto lo toma cpor defecto como si fuera por id pero creo el suyo propio
		 ademas de eso lo puso en el repositorio*/
		 
	public User fetchUserByEmail(String email){
	 return  repo.findByEmail(email);
	}
	
	public User fetchUserByEmailAndPassword(String email,String password){
	 return  repo.findByEmailAndPassword(email,password);
	}

	
}

