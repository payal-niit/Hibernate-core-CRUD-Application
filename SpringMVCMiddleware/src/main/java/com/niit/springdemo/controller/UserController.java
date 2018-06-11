package com.niit.springdemo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.springdemo.model.User;
import com.niit.springdemo.service.UserService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class UserController {
	@Autowired
	UserService userService;
	
	/*@RequestMapping("/")
	public List<User> getList(Model model) {
		System.out.println(userService.getUserList().size());
		return userService.getUserList();		
	}*/
	@GetMapping("/")
	public ResponseEntity<List<User>> getUserList() {
		userService.getUserList();
		return new ResponseEntity<List<User>>(userService.getUserList(),HttpStatus.OK);		
	}
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") int userId) {
		//userService.getUserList();
		return new ResponseEntity<User>(userService.getUserById(userId),HttpStatus.OK);		
	}
	
	@PostMapping
	public ResponseEntity<Void> adduser(@RequestBody User user) {
		userService.createUser(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	@PutMapping
	public ResponseEntity<Void> updateUser(@RequestBody User user) {
		
		userService.updateUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteUser(@RequestBody User user) {
		
		userService.deleteUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	/*@GetMapping("/")
	public ResponseEntity<List<User>> userList() {
		if (userService.getUserList().size() != 0) {
			return new ResponseEntity<List<User>>(userService.getUserList(), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
	}*/
	
	@GetMapping("/search/{username}")
	public ResponseEntity<List<User>> userListByName(@PathVariable("username") String username) {
		
			return new ResponseEntity<List<User>>(userService.getUserListByName(username), HttpStatus.OK);
		
	}

	/*@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable("userId") int userId) {
		return new ResponseEntity<User>(userService.getUserById(userId),HttpStatus.OK);
	}*/
	
	/*@PostMapping
	public ResponseEntity<Void> addUser(@RequestBody User user) {
		userService.createUser(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Void> updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@DeleteMapping()
	public ResponseEntity<Void> deleteUser(@RequestBody User user) {
		userService.deleteUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}*/
	
	/*@RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
	public void corsHeaders(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
		response.addHeader("Access-Control-Max-Age", "3600");
	}*/


}
