package com.skilldistillery.dmtool.controllers;

import java.security.Principal;
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
import com.skilldistillery.dmtool.services.CampaignService;

@RestController
@RequestMapping(path = "api")
@CrossOrigin({ "*", "http://localhost:4200" })
public class CampaignController {
	@Autowired
	private CampaignService campServ;

	

	@RequestMapping(path = "campaign/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	// Need to include user id in path to get all notes for a specific campaign
	@RequestMapping(path = "campaign/all", method = RequestMethod.GET)
	public Set<Campaign> index(HttpServletRequest req, HttpServletResponse res, Principal principal) {
		return campServ.index(principal.getName());
	}

	@RequestMapping(path = "campaign/{cid}")
	public Campaign show(HttpServletRequest req, HttpServletResponse res, @PathVariable int cid) {
		return campServ.show(cid);
	}

	@RequestMapping(path = "campaign", method = RequestMethod.POST)
	public Campaign create(@RequestBody Campaign campaign, HttpServletRequest request,
			HttpServletResponse response, Principal principal) {
		Campaign camp = campServ.create(principal.getName(), campaign);

		if (camp != null) {
			response.setStatus(200);
			return camp;

		}
		response.setStatus(500);
		return camp;
	}

	@RequestMapping(path = "campaign/{cid}", method = RequestMethod.PATCH)
	public Campaign update(@PathVariable int cid, @RequestBody Campaign campaign, HttpServletRequest request,
			HttpServletResponse response, Principal principal) {
		System.out.println(campaign);
		Campaign camp = campServ.update(principal.getName(), cid, campaign);

		if (camp != null) {
			response.setStatus(200);
			return camp;

		}
		response.setStatus(500);
		return camp;
	}

	@RequestMapping(path = "campaign/{cid}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable int cid, HttpServletRequest request, HttpServletResponse response, Principal principal) {
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