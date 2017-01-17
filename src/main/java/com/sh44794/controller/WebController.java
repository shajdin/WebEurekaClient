package com.sh44794.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sh44794.model.User;
import com.sh44794.service.UserService;

@RestController
public class WebController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(path="/info", method=RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public String info(){
		return "Eureka client running OK!";
	}

	@RequestMapping(path="/hello", method=RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public String hello(){
		return "Hello world!!";
	}
	
	@RequestMapping(path="/users/{id}", method=RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public User getUserById(@PathVariable long id){
		return userService.findById(id);
	}
	
	@RequestMapping(path="/test", method=RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public User test(){
		return userService.findById(2L);
	}
	
	@RequestMapping(path="/all", method=RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<User> users(){
		return userService.getAll();
	}
	
	
	@RequestMapping(path="/postTest", method=RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<User> postUsers(){
		User u = new User();
		u.setFirstName("IMEEE");
		u.setLastName("PREZIME");
		u.setUsername("SUGO");
		return userService.postUser(u);
	}
}
