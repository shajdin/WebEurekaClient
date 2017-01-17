package com.sh44794.service;

import java.util.List;

import com.sh44794.model.User;

public interface UserService {
	
	User findById(Long id);
	
	List<User> getAll();

	List<User> postUser(User user);
	

}
