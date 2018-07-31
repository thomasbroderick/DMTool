package com.skilldistillery.dmtool.services;

import java.util.Set;

import com.skilldistillery.dmtool.entities.Npc;

public interface NpcService {
	  public Set<Npc> index(String username);

	  public Npc show(String username, int nid);

	  public Npc create(String username, Npc npc);

	  public Npc update(String username, int nid, Npc npc);

	  public void destroy(String username, int nid);

}
