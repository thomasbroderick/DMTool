package com.skilldistillery.dmtool.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.dmtool.entities.User;
import com.skilldistillery.dmtool.repositories.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	

	@Autowired
	private UserRepository userRepo;

	@SuppressWarnings("unchecked")
	@Override
	public Set<User> index() {
		return (Set<User>) userRepo.findAll();
	}

	@Override
	public User show(int uid) {
		return userRepo.findById(uid).get();
	}

	@Override
	public User create(User user) {
		return userRepo.saveAndFlush(user);
	}

	@Override
	public User update(int uid, User user) {
		user.setId(uid);
		return userRepo.saveAndFlush(user);
	}

	@Override
	public void destroy(int uid) {
		userRepo.deleteById(uid);
	}

}
