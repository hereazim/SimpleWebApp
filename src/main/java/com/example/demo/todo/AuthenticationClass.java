package com.example.demo.todo;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationClass {
	public boolean authenticate(String username,String password) {
		boolean isUser=username.equalsIgnoreCase("Webuser");
		boolean isPassword=password.equalsIgnoreCase("User1@web");
		return isUser && isPassword;
	}
}
