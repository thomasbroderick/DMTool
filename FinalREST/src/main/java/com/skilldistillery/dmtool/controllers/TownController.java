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

import com.skilldistillery.dmtool.entities.Town;
import com.skilldistillery.dmtool.services.TownService;

@RestController
@RequestMapping(path = "api")
@CrossOrigin({ "*", "http://localhost:4200" })
public class TownController {
	@Autowired
	private TownService townServ;
	

	@RequestMapping(path = "town/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	// Need to include campaign id in path to get all towns for a specific campaign
	@RequestMapping(path = "town/all/{cid}", method = RequestMethod.GET)
	public Set<Town> index(@PathVariable int cid, HttpServletRequest req, HttpServletResponse res) {
		return townServ.index(cid);
	}

	@RequestMapping(path = "town/{tid}")
	public Town show(HttpServletRequest req, HttpServletResponse res, @PathVariable int tid) {
		return townServ.show(tid);
	}

	@RequestMapping(path = "town/{cid}", method = RequestMethod.POST)
	public Town create(@RequestBody Town town, @PathVariable int cid, HttpServletRequest request,
			HttpServletResponse response) {
		Town to = townServ.create(cid, town);

		if (to != null) {
			response.setStatus(200);
			return to;

		}
		response.setStatus(500);
		return to;
	}

	@RequestMapping(path = "town/{tid}", method = RequestMethod.PUT)
	public Town update(@PathVariable int tid, @RequestBody Town town, HttpServletRequest request,
			HttpServletResponse response) {
		Town to = townServ.update(tid, town);

		if (to != null) {
			response.setStatus(200);
			return to;

		}
		response.setStatus(500);
		return to;
	}

	@RequestMapping(path = "town/{tid}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable int tid, HttpServletRequest request, HttpServletResponse response) {
		townServ.destroy(tid);
		response.setStatus(500);
		try {
		townServ.show(tid);
		}
		catch(Exception e) {
			response.setStatus(200);
		}
	}

}