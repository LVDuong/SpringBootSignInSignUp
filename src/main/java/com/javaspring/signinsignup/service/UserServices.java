package com.javaspring.signinsignup.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspring.signinsignup.model.User;
import com.javaspring.signinsignup.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	UserRepository userRepository;

	public Collection<? extends User> getAllUser() {
		List<User> userList = new ArrayList<>();
		userRepository.findAll().forEach(userList::add);
		return userList;
	}
	
	public String saveUser_(User user) {
		User savedUser = userRepository.save(user);
		if(savedUser!=null) {
			return "Saved : id - " + savedUser.getId();
		} else {
			return "Failed : id - " + user.getId();
		}
	}
}
