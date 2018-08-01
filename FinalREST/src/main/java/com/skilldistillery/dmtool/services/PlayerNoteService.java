package com.skilldistillery.dmtool.services;

import java.util.Set;

import com.skilldistillery.dmtool.entities.PlayerNote;

public interface PlayerNoteService {
	  public Set<PlayerNote> index(int pid);

	  public PlayerNote show(int pid);

	  public PlayerNote create(int pid, PlayerNote playerNote);

	  public PlayerNote update(int pid, PlayerNote playerNote);

	  public void destroy(int pid);
}
