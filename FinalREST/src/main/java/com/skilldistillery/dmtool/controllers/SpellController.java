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

import com.skilldistillery.dmtool.entities.Spell;
import com.skilldistillery.dmtool.services.SpellService;

@RestController
@RequestMapping(path = "api")
@CrossOrigin({ "*", "http://localhost:4200" })
public class SpellController {
	@Autowired
	private SpellService spellServ;

	@RequestMapping(path = "spell/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	// Need to include user id in path to get all spells for a specific user
	@RequestMapping(path = "spell/all", method = RequestMethod.GET)
	public Set<Spell> index(HttpServletRequest req, HttpServletResponse res, Principal principal) {
		return spellServ.index(principal.getName());
	}

	@RequestMapping(path = "spell/{sid}")
	public Spell show(HttpServletRequest req, HttpServletResponse res, @PathVariable int sid, Principal principal) {
		return spellServ.show(sid);
	}

	@RequestMapping(path = "spell", method = RequestMethod.POST)
	public Spell create(@RequestBody Spell spell, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		Spell sp = spellServ.create(principal.getName(), spell);

		if (sp != null) {
			response.setStatus(200);
			return sp;

		}
		response.setStatus(500);
		return sp;
	}

	@RequestMapping(path = "spell/{sid}", method = RequestMethod.PATCH)
	public Spell update(@PathVariable int sid, @RequestBody Spell spell, HttpServletRequest request,
			HttpServletResponse response, Principal principal) {
		Spell sp = spellServ.update(principal.getName(), sid, spell);

		if (sp != null) {
			response.setStatus(200);
			return sp;

		}
		response.setStatus(500);
		return sp;
	}

	@RequestMapping(path = "spell/{sid}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable int sid, HttpServletRequest request, HttpServletResponse response,
			Principal principal) {
		response.setStatus(500);
		if (spellServ.checkAbilityToModify(principal.getName(), sid)) {
			spellServ.destroy(sid);
			try {
				spellServ.show(sid);
			} catch (Exception e) {
				response.setStatus(200);
			}
		}

	}

}