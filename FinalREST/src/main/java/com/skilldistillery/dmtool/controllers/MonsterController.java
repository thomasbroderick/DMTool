package com.skilldistillery.dmtool.controllers;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.dmtool.entities.Monster;
import com.skilldistillery.dmtool.services.MonsterService;
import com.skilldistillery.dmtool.services.UserService;

@RestController
@RequestMapping(path = "api")
@CrossOrigin({ "*", "http://localhost:4200" })
public class MonsterController {
	@Autowired
	private MonsterService monServ;
	
	@Autowired
	private UserService userServ;
	

	@RequestMapping(path = "monster/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	// Need to include user id in path to get all notes for a specific campaign
	@RequestMapping(path = "user/{uid}/monster/all", method = RequestMethod.GET)
	public Set<Monster> index(@PathVariable int uid, HttpServletRequest req, HttpServletResponse res) {
		return monServ.index(userServ.show(uid).getEmail());
	}

	@RequestMapping(path = "monster/{mid}")
	public Monster show(HttpServletRequest req, HttpServletResponse res, @PathVariable int mid) {
		return monServ.show(mid);
	}

	@RequestMapping(path = "user/{uid}/monster", method = RequestMethod.POST)
	public Monster create(@RequestBody Monster monster, @PathVariable int uid, HttpServletRequest request,
			HttpServletResponse response) {
		Monster mon = monServ.create(userServ.show(uid).getEmail(), monster);

		if (mon != null) {
			response.setStatus(200);
			return mon;

		}
		response.setStatus(500);
		return mon;
	}

	@RequestMapping(path = "user/{uid}/monster/{mid}", method = RequestMethod.PATCH)
	public Monster update(@PathVariable int uid, @PathVariable int mid, @RequestBody Monster monster, HttpServletRequest request,
			HttpServletResponse response) {
		Monster mon = monServ.update(userServ.show(uid).getEmail(), mid, monster);

		if (mon != null) {
			response.setStatus(200);
			return mon;

		}
		response.setStatus(500);
		return mon;
	}

	@RequestMapping(path = "monster/{mid}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable int mid, HttpServletRequest request, HttpServletResponse response) {
		monServ.destroy(mid);
		response.setStatus(500);
		try {
		monServ.show(mid);
		}
		catch(Exception e) {
			response.setStatus(200);
		}
	}

}