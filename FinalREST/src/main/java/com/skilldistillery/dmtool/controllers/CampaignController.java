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

import com.skilldistillery.dmtool.entities.Campaign;
import com.skilldistillery.dmtool.entities.User;
import com.skilldistillery.dmtool.services.CampaignService;
import com.skilldistillery.dmtool.services.UserService;

@RestController
@RequestMapping(path = "api")
@CrossOrigin({ "*", "http://localhost:4200" })
public class CampaignController {
	@Autowired
	private CampaignService campServ;
	@Autowired
	private UserService userServ;
	

	@RequestMapping(path = "campaign/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	// Need to include user id in path to get all notes for a specific campaign
	@RequestMapping(path = "campaign/all/user/{uid}", method = RequestMethod.GET)
	public Set<Campaign> index(@PathVariable int uid, HttpServletRequest req, HttpServletResponse res) {
		return campServ.index(userServ.show(uid).getEmail());
	}

	@RequestMapping(path = "campaign/{cid}")
	public Campaign show(HttpServletRequest req, HttpServletResponse res, @PathVariable int cid) {
		return campServ.show(cid);
	}

	@RequestMapping(path = "campaign/user/{uid}", method = RequestMethod.POST)
	public Campaign create(@RequestBody Campaign campaign, @PathVariable int uid, HttpServletRequest request,
			HttpServletResponse response) {
		Campaign camp = campServ.create(userServ.show(uid).getEmail(), campaign);

		if (camp != null) {
			response.setStatus(200);
			return camp;

		}
		response.setStatus(500);
		return camp;
	}

	@RequestMapping(path = "campaign/{uid}/{cid}", method = RequestMethod.PATCH)
	public Campaign update(@PathVariable int uid, @PathVariable int cid, @RequestBody Campaign campaign, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(campaign);
		Campaign camp = campServ.update(userServ.show(uid).getEmail(), cid, campaign);

		if (camp != null) {
			response.setStatus(200);
			return camp;

		}
		response.setStatus(500);
		return camp;
	}

	@RequestMapping(path = "campaign/{cid}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable int cid, HttpServletRequest request, HttpServletResponse response) {
		campServ.destroy(cid);
		response.setStatus(500);
		try {
		campServ.show(cid);
		}
		catch(Exception e) {
			response.setStatus(200);
		}
	}

}