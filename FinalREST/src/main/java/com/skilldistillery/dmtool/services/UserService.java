package com.skilldistillery.dmtool.services;

import java.util.Set;

import com.skilldistillery.dmtool.entities.User;

public interface UserService {
	  public Set<User> index(String username);

	  public User show(String username, int uid);

	  public User create(String username, User user);

	  public User update(String username, int uid, User user);

	  public void destroy(String username, int uid);

}
