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

import com.skilldistillery.dmtool.entities.PlayerNote;
import com.skilldistillery.dmtool.services.PlayerNoteService;

@RestController
@RequestMapping(path = "api")
@CrossOrigin({ "*", "http://localhost:4200" })
public class PlayerNoteController {
	@Autowired
	private PlayerNoteService noteServ;
	

	@RequestMapping(path = "playernote/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	// Need to include player id in path to get all notes for a specific player
	@RequestMapping(path = "player/{pid}/playernote/all", method = RequestMethod.GET)
	public Set<PlayerNote> index(@PathVariable int pid, HttpServletRequest req, HttpServletResponse res) {
		return noteServ.index(pid);
	}

	@RequestMapping(path = "playernote/{pid}")
	public PlayerNote show(HttpServletRequest req, HttpServletResponse res, @PathVariable int pid) {
		return noteServ.show(pid);
	}

	@RequestMapping(path = "player/{pid}/playernote", method = RequestMethod.POST)
	public PlayerNote create(@RequestBody PlayerNote playerNote, @PathVariable int pid, HttpServletRequest request,
			HttpServletResponse response) {
		PlayerNote note = noteServ.create(pid, playerNote);

		if (note != null) {
			response.setStatus(200);
			return note;

		}
		response.setStatus(500);
		return note;
	}

	@RequestMapping(path = "player/{pid}/playernote/{pnid}", method = RequestMethod.PATCH)
	public PlayerNote update(@PathVariable int pid ,@PathVariable int pnid, @RequestBody PlayerNote playerNote, HttpServletRequest request,
			HttpServletResponse response) {
		PlayerNote note = noteServ.update(pid, pnid, playerNote);
		

		if (note != null) {
			response.setStatus(200);
			return note;

		}
		response.setStatus(500);
		return note;
	}

	@RequestMapping(path = "playernote/{pid}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable int pid, HttpServletRequest request, HttpServletResponse response) {
		noteServ.destroy(pid);
		response.setStatus(500);
		try {
		noteServ.show(pid);
		}
		catch(Exception e) {
			response.setStatus(200);
		}
	}

}