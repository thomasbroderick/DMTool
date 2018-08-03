package com.skilldistillery.dmtool.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.dmtool.entities.Player;
import com.skilldistillery.dmtool.services.PlayerService;

@RestController
@RequestMapping(path = "api")
@CrossOrigin({ "*", "http://localhost:4200" })
public class PlayerController {
	@Autowired
	private PlayerService playerServ;
	

	@RequestMapping(path = "player/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	// Need to include campaign id in path to get all players for a specific campaign
	@RequestMapping(path = "campaign/{cid}/player/all", method = RequestMethod.GET)
	public List<Player> index(@PathVariable int cid, HttpServletRequest req, HttpServletResponse res, Principal principal) {
		return playerServ.index(cid);
	}

	@RequestMapping(path = "player/{pid}")
	public Player show(HttpServletRequest req, HttpServletResponse res, @PathVariable int pid, Principal principal) {
		return playerServ.show(pid);
	}

	@RequestMapping(path = "campaign/{cid}/player", method = RequestMethod.POST)
	public Player create(@RequestBody Player player, @PathVariable int cid, HttpServletRequest request,
			HttpServletResponse response, Principal principal) {
		Player play = playerServ.create(cid, player);

		if (play != null) {
			response.setStatus(200);
			return play;

		}
		response.setStatus(500);
		return play;
	}

	@RequestMapping(path = "campaign/{cid}/player/{pid}", method = RequestMethod.PATCH)
	public Player update(@PathVariable int cid, @PathVariable int pid, @RequestBody Player player, HttpServletRequest request,
			HttpServletResponse response, Principal principal) {
		Player play = playerServ.update(cid, pid, player);

		if (play != null) {
			response.setStatus(200);
			return play;

		}
		response.setStatus(500);
		return play;
	}

	@RequestMapping(path = "player/{pid}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable int pid, HttpServletRequest request, HttpServletResponse response, Principal principal) {
		playerServ.destroy(pid);
		response.setStatus(500);
		try {
		playerServ.show(pid);
		}
		catch(Exception e) {
			response.setStatus(200);
		}
	}

}