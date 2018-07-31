package com.skilldistillery.dmtool.services;

import java.util.Set;

import com.skilldistillery.dmtool.entities.Town;

public interface TownService {
	  public Set<Town> index(String username);

	  public Town show(String username, int tid);

	  public Town create(String username, Town town);

	  public Town update(String username, int tid, Town town);

	  public void destroy(String username, int tid);

}
