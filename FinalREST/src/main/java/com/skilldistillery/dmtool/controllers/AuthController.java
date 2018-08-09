package com.skilldistillery.dmtool.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.dmtool.entities.User;
import com.skilldistillery.dmtool.services.AuthService;

@RestController
@RequestMapping(path = "api")
@CrossOrigin({"*", "http://localhost:4200"})
public class AuthController {
	
	@Autowired
	private AuthService authServ;
	
	@RequestMapping(path = "register", method = RequestMethod.POST)
	public User register(@RequestBody String json, HttpServletResponse res) {
		System.out.println(json);

	  User u =  authServ.register(json);

	  if (u == null) {
	    res.setStatus(400);
	  }

	  return u;
	}

	@RequestMapping(path = "authenticate", method = RequestMethod.GET)
	public Principal authenticate(Principal principal, HttpServletResponse res) {
	  return principal;
	}

}
