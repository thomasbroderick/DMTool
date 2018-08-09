package com.skilldistillery.dmtool.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skilldistillery.dmtool.entities.User;
import com.skilldistillery.dmtool.repositories.UserRepository;



@Service
public class AuthServiceImpl implements AuthService {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public User register(String json) {
		ObjectMapper om = new ObjectMapper();
		User user = null;
		

		try {
			user = om.readValue(json, User.class);
			System.out.println(user);

			String encodedPW = encoder.encode(user.getPassword());
			user.setPassword(encodedPW); // only persist encoded password
			user.setEnabled(true);
			user.setRole("standard");
			user = userRepo.saveAndFlush(user);
		} catch (Exception e) {
			System.out.println(e);
		}		
		return user;
	}
}