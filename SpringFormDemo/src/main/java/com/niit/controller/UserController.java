package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.springdemo.model.User;
import com.niit.springdemo.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	//@RequestMapping("/")
	@GetMapping("/")
	public String getHome(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("userList", userService.getUserList());
		return "index";
	}
	@PostMapping("/adduser")
	public String addUser(@ModelAttribute("user") User user) {		
		userService.createUser(user);
		return "redirect:/";
	}
	@GetMapping("/edituser{userId}")
	public String getUser(@PathVariable("userId") int userId, Model model) {
		model.addAttribute("user",userService.getUserById(userId));
		return "index";
	}
	
	@RequestMapping("/updateuser")
	public String updateUser(@ModelAttribute("user") User user) {
		userService.updateUser(user);
		return "redirect:/";
	}
	
	@RequestMapping("/deleteuser{userId}")
	public String deleteUser(@PathVariable("userId") int userId) {
		User user = userService.getUserById(userId);
		userService.deleteUser(user);
		return "redirect:/";
	}
}
