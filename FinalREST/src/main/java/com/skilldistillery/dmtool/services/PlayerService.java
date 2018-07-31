package com.skilldistillery.dmtool.services;

import java.util.Set;

import com.skilldistillery.dmtool.entities.Player;

public interface PlayerService {
	  public Set<Player> index(String username);

	  public Player show(String username, int pid);

	  public Player create(String username, Player player);

	  public Player update(String username, int pid, Player player);

	  public void destroy(String username, int pid);
}
