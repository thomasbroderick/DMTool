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

import com.skilldistillery.dmtool.entities.Spell;
import com.skilldistillery.dmtool.services.SpellService;
import com.skilldistillery.dmtool.services.UserService;

@RestController
@RequestMapping(path = "api")
@CrossOrigin({ "*", "http://localhost:4200" })
public class SpellController {
	@Autowired
	private SpellService spellServ;
	@Autowired
	private UserService userServ;
	

	@RequestMapping(path = "spell/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	// Need to include user id in path to get all spells for a specific user
	@RequestMapping(path = "spell/all/{uid}", method = RequestMethod.GET)
	public Set<Spell> index(@PathVariable int uid, HttpServletRequest req, HttpServletResponse res) {
		return spellServ.index(userServ.show(uid).getEmail());
	}

	@RequestMapping(path = "spell/{sid}")
	public Spell show(HttpServletRequest req, HttpServletResponse res, @PathVariable int sid) {
		return spellServ.show(sid);
	}

	@RequestMapping(path = "spell/{uid}", method = RequestMethod.POST)
	public Spell create(@RequestBody Spell spell, @PathVariable int uid, HttpServletRequest request,
			HttpServletResponse response) {
		Spell sp = spellServ.create(userServ.show(uid).getEmail(), spell);

		if (sp != null) {
			response.setStatus(200);
			return sp;

		}
		response.setStatus(500);
		return sp;
	}

	@RequestMapping(path = "spell/{sid}", method = RequestMethod.PUT)
	public Spell update(@PathVariable int sid, @RequestBody Spell spell, HttpServletRequest request,
			HttpServletResponse response) {
		Spell sp = spellServ.update(sid, spell);

		if (sp != null) {
			response.setStatus(200);
			return sp;

		}
		response.setStatus(500);
		return sp;
	}

	@RequestMapping(path = "spell/{sid}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable int sid, HttpServletRequest request, HttpServletResponse response) {
		spellServ.destroy(sid);
		response.setStatus(500);
		try {
		spellServ.show(sid);
		}
		catch(Exception e) {
			response.setStatus(200);
		}
	}

}