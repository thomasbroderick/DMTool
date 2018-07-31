package com.skilldistillery.dmtool.services;

import java.util.Set;

import com.skilldistillery.dmtool.entities.Spell;

public interface SpellService {
	  public Set<Spell> index(String username);

	  public Spell show(String username, int sid);

	  public Spell create(String username, Spell spell);

	  public Spell update(String username, int sid, Spell spell);

	  public void destroy(String username, int sid);
}
