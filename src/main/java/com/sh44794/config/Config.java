package com.sh44794.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.sh44794.service.UserService;
import com.sh44794.service.UserServiceImpl;

@Configuration
public class Config {
	
	public static final String USERS_SERVICE_URL = "http://USERS-SERVICE";
	
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	UserService userService(){
		return new UserServiceImpl(USERS_SERVICE_URL);
	}

}
