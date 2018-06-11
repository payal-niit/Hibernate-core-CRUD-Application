package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.springdemo.model.User;
import com.niit.springdemo.service.UserService;

//Spring Restful web services API - through which you can directly call the data
//the data will be in the form of JSON

@RestController
@RequestMapping("user/api/")
public class UserRestController {
	@Autowired
	UserService userService;
	
	@GetMapping
	public List<User> getHome(Model model) {
		//model.addAttribute("user", new User());
		return userService.getUserList();
		
	}

}
