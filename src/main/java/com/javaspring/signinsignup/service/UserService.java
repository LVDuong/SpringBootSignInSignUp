package com.javaspring.signinsignup.service;

import com.javaspring.signinsignup.model.User;

public interface UserService {

	public User findUserByEmail(String email);
	
	public void saveUser(User user);
}
