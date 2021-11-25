package com.javaspring.signinsignup.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaspring.signinsignup.model.User;
import com.javaspring.signinsignup.service.UserService;
import com.javaspring.signinsignup.service.UserServices;


@RestController
@RequestMapping(path="/user")
public class UserControllers {

	@Autowired
	UserServices userServices;
	//UserRepository userRepository;
	
	@GetMapping(path="/getAllUsers")
	public List<User> getAllUsers (){
		List<User> userList = new ArrayList<>();
		userList.addAll(userServices.getAllUser());
		return userList;
	}
	
	@PostMapping(path="/saveUser", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String saveUser(@RequestBody User user) {
		return userServices.saveUser_(user);
	}
	
	
}