package com.skilldistillery.dmtool.services;

import java.util.Set;

import com.skilldistillery.dmtool.entities.Player;

public interface PlayerService {
	  public Set<Player> index(int cid);

	  public Player show(int pid);

	  public Player create(int cid, Player player);

	  public Player update(int cid, int pid, Player player);

	  public void destroy(int pid);
}
