package com.skilldistillery.dmtool.services;

import java.util.Set;

import com.skilldistillery.dmtool.entities.PlayerNote;

public interface PlayerNoteService {
	  public Set<PlayerNote> index(String username);

	  public PlayerNote show(String username, int pid);

	  public PlayerNote create(String username, PlayerNote playerNote);

	  public PlayerNote update(String username, int pid, PlayerNote playerNote);

	  public void destroy(String username, int pid);
}
