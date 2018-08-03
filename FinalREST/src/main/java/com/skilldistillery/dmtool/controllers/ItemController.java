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

import com.skilldistillery.dmtool.entities.Item;
import com.skilldistillery.dmtool.services.ItemService;

@RestController
@RequestMapping(path = "api")
@CrossOrigin({ "*", "http://localhost:4200" })
public class ItemController {
	@Autowired
	private ItemService itemServ;
	

	@RequestMapping(path = "item/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	// Need to include user id in path to get all notes for a specific campaign
	@RequestMapping(path = "item/all", method = RequestMethod.GET)
	public Set<Item> index(HttpServletRequest req, HttpServletResponse res, Principal principal) {
		return itemServ.index(principal.getName());
	}

	@RequestMapping(path = "item/{iid}")
	public Item show(HttpServletRequest req, HttpServletResponse res, @PathVariable int iid, Principal principal) {
		return itemServ.show(iid);
	}

	@RequestMapping(path = "item", method = RequestMethod.POST)
	public Item create(@RequestBody Item item, HttpServletRequest request,
			HttpServletResponse response, Principal principal) {
		Item it = itemServ.create(principal.getName(), item);

		if (it != null) {
			response.setStatus(200);
			return it;

		}
		response.setStatus(500);
		return it;
	}

	@RequestMapping(path = "item/{iid}", method = RequestMethod.PATCH)
	public Item update(@PathVariable int iid, @RequestBody Item item, HttpServletRequest request,
			HttpServletResponse response, Principal principal) {
		Item it = itemServ.update(principal.getName(), iid, item);

		if (it != null) {
			response.setStatus(200);
			return it;

		}
		response.setStatus(500);
		return it;
	}

	@RequestMapping(path = "item/{iid}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable int iid, HttpServletRequest request, HttpServletResponse response, Principal principal) {
		itemServ.destroy(iid);
		response.setStatus(500);
		try {
		itemServ.show(iid);
		}
		catch(Exception e) {
			response.setStatus(200);
		}
	}

}