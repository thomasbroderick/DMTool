package com.skilldistillery.dmtool.services;

import java.util.Set;

import com.skilldistillery.dmtool.entities.User;

public interface UserService {
	  public Set<User> index();

	  public User show(int uid);

	  public User create(User user);

	  public User update(int uid, User user);

	  public void destroy(int uid);

}