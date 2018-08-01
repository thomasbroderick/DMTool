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

import com.skilldistillery.dmtool.entities.Item;
import com.skilldistillery.dmtool.services.ItemService;
import com.skilldistillery.dmtool.services.UserService;

@RestController
@RequestMapping(path = "api")
@CrossOrigin({ "*", "http://localhost:4200" })
public class ItemController {
	@Autowired
	private ItemService itemServ;
	@Autowired
	private UserService userServ;
	

	@RequestMapping(path = "item/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	// Need to include user id in path to get all notes for a specific campaign
	@RequestMapping(path = "item/all/{uid}", method = RequestMethod.GET)
	public Set<Item> index(@PathVariable int uid, HttpServletRequest req, HttpServletResponse res) {
		return itemServ.index(userServ.show(uid).getEmail());
	}

	@RequestMapping(path = "item/{iid}")
	public Item show(HttpServletRequest req, HttpServletResponse res, @PathVariable int iid) {
		return itemServ.show(iid);
	}

	@RequestMapping(path = "item/{uid}", method = RequestMethod.POST)
	public Item create(@RequestBody Item item, @PathVariable int uid, HttpServletRequest request,
			HttpServletResponse response) {
		Item it = itemServ.create(userServ.show(uid).getEmail(), item);

		if (it != null) {
			response.setStatus(200);
			return it;

		}
		response.setStatus(500);
		return it;
	}

	@RequestMapping(path = "item/{iid}", method = RequestMethod.PUT)
	public Item update(@PathVariable int iid, @RequestBody Item item, HttpServletRequest request,
			HttpServletResponse response) {
		Item it = itemServ.update(iid, item);

		if (it != null) {
			response.setStatus(200);
			return it;

		}
		response.setStatus(500);
		return it;
	}

	@RequestMapping(path = "item/{iid}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable int iid, HttpServletRequest request, HttpServletResponse response) {
		itemServ.destroy(iid);
		Item it = itemServ.show(iid);
		if (it != null) {
			response.setStatus(500);

		} else {
			response.setStatus(200);
		}
	}

}