package com.skilldistillery.dmtool.services;

import com.skilldistillery.dmtool.entities.User;

public interface AuthService {
	public User register(String json);
}
