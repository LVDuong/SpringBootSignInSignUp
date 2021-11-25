package com.javaspring.signinsignup.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.javaspring.signinsignup.model.User;
import com.javaspring.signinsignup.service.UserService;
import com.javaspring.signinsignup.service.UserServices;

import javassist.expr.NewArray;

@RestController
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	private UserServices userServices;
	
	@RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();
		
		model.setViewName("user/login");
		return model;
	}
	
	@RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("user", user);
		model.setViewName("user/signup");
		
		return model;
	}
	
	@RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
	public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		
		if(userExists !=null) {
			bindingResult.rejectValue("email", "error.user", "This email already exist!");
		}
		if(bindingResult.hasErrors()) {
			model.setViewName("user/signup");
		} else {
			userService.saveUser(user);
			model.addObject("msg", "User has been resigtered successfully!");
			model.addObject("user", new User());
			model.setViewName("user/signup");
		}
		
		return model;
	}
	
	@RequestMapping(value= {"/home/home"}, method=RequestMethod.POST)
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		
		model.addObject("username", user.getFirstname() + "" + user.getLastname());
		model.setViewName("home/home");
		return model;
	}
	
	@RequestMapping(value= {"/access_denied"}, method=RequestMethod.POST)
	public ModelAndView accessDenied() {
		ModelAndView model = new ModelAndView();
		model.setViewName("errors/access_denied");
		return model;
	}
	
	/*@RequestMapping(value= {"user/getAllUsers"}, method=RequestMethod.GET)
	public List<User> getAllUsers (){
		List<User> userList = new ArrayList<>();
		userList.addAll(userServices.getAllUser());
		return userList;
	}
	
	@RequestMapping(path= {"user/saveUser"}, method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String saveUser(@RequestBody User user) {
		return userServices.saveUser_(user);
	}*/
}
