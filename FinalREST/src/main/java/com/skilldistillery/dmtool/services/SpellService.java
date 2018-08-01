package com.skilldistillery.dmtool.services;

import java.util.Set;

import com.skilldistillery.dmtool.entities.Spell;

public interface SpellService {
	  public Set<Spell> index(String email);

	  public Spell show(int sid);

	  public Spell create(String email, Spell spell);

	  public Spell update(int sid, Spell spell);

	  public void destroy(int sid);
}
