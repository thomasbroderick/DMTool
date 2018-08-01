package com.skilldistillery.dmtool.services;

import java.util.Set;

import com.skilldistillery.dmtool.entities.Npc;

public interface NpcService {
	  public Set<Npc> index(int cid);

	  public Npc show(int nid);

	  public Npc create(int nid, Npc npc);

	  public Npc update(int cid, int nid, Npc npc);

	  public void destroy(int nid);

}
