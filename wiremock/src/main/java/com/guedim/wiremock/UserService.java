package com.guedim.wiremock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class UserService {

	//@Autowired
	private UserFeignClient userFeignClient;

	public String getUsers() {
		return userFeignClient.getUsers();
	}
}
