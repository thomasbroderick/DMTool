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

import com.skilldistillery.dmtool.entities.CampaignNote;
import com.skilldistillery.dmtool.services.CampaignNoteService;

@RestController
@RequestMapping(path = "api")
@CrossOrigin({ "*", "http://localhost:4200" })
public class CampaignNoteController {
	@Autowired
	private CampaignNoteService noteServ;

	@RequestMapping(path = "campaignnote/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	
	//Need to include campaign id in path to get all notes for a specific campaign
	@RequestMapping(path = "campaignnote/all/{cid}", method = RequestMethod.GET)
	public Set<CampaignNote> index(@PathVariable int cid, HttpServletRequest req, HttpServletResponse res) {
		return noteServ.index(cid);
	}

	@RequestMapping(path = "campaignnote/{nid}")
	public CampaignNote show(HttpServletRequest req, HttpServletResponse res, @PathVariable int nid) {
		return noteServ.show(nid);
	}


	@RequestMapping(path = "campaignnote/{cid}", method = RequestMethod.POST)
	public CampaignNote create(@RequestBody CampaignNote campaignNote,  @PathVariable int cid, HttpServletRequest req, HttpServletResponse res) {
		CampaignNote note = noteServ.create(cid, campaignNote);
		  if(note != null) {
			  res.setStatus(200);
			  return note;
			  
		  }
		  res.setStatus(500);
		  return note;
	}

	  @RequestMapping(path="campaignnote/{nid}", method=RequestMethod.PUT)
	  public CampaignNote update(@PathVariable int nid, @RequestBody CampaignNote campaignNote, HttpServletRequest request, HttpServletResponse response){ 
		  CampaignNote note = noteServ.update(nid, campaignNote); 
		  
		  if(note != null) {
			  response.setStatus(200);
			  return note;
			  
		  }
		  response.setStatus(500);
		  return note;
}
		@RequestMapping(path = "campaignnote/{nid}", method = RequestMethod.DELETE)
		public void destroy(@PathVariable int nid, HttpServletRequest req, HttpServletResponse res, Principal principal) {
			noteServ.destroy(nid);
			CampaignNote note = noteServ.show(nid);
			if (note != null) {
				res.setStatus(200);

			} else {
				res.setStatus(500);
			}
		}
		

}