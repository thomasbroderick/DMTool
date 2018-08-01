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

import com.skilldistillery.dmtool.entities.Npc;
import com.skilldistillery.dmtool.services.NpcService;

@RestController
@RequestMapping(path = "api")
@CrossOrigin({ "*", "http://localhost:4200" })
public class NpcController {
	@Autowired
	private NpcService npcServ;
	

	@RequestMapping(path = "npc/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	// Need to include campaign id in path to get all npcs for a specific campaign
	@RequestMapping(path = "npc/all/{cid}", method = RequestMethod.GET)
	public Set<Npc> index(@PathVariable int cid, HttpServletRequest req, HttpServletResponse res) {
		return npcServ.index(cid);
	}

	@RequestMapping(path = "npc/{nid}")
	public Npc show(HttpServletRequest req, HttpServletResponse res, @PathVariable int nid) {
		return npcServ.show(nid);
	}

	@RequestMapping(path = "npc/{cid}", method = RequestMethod.POST)
	public Npc create(@RequestBody Npc npc, @PathVariable int cid, HttpServletRequest request,
			HttpServletResponse response) {
		Npc n = npcServ.create(cid, npc);

		if (n != null) {
			response.setStatus(200);
			return n;

		}
		response.setStatus(500);
		return n;
	}

	@RequestMapping(path = "npc/{nid}", method = RequestMethod.PUT)
	public Npc update(@PathVariable int nid, @RequestBody Npc npc, HttpServletRequest request,
			HttpServletResponse response) {
		Npc n = npcServ.update(nid, npc);

		if (n != null) {
			response.setStatus(200);
			return n;

		}
		response.setStatus(500);
		return n;
	}

	@RequestMapping(path = "npc/{nid}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable int nid, HttpServletRequest request, HttpServletResponse response) {
		npcServ.destroy(nid);
		response.setStatus(500);
		try {
		npcServ.show(nid);
		}
		catch(Exception e) {
			response.setStatus(200);
		}
	}

}