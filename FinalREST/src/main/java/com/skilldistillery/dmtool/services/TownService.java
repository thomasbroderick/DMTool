package com.skilldistillery.dmtool.services;

import java.util.Set;

import com.skilldistillery.dmtool.entities.Town;

public interface TownService {
	  public Set<Town> index(int cid);

	  public Town show(int tid);

	  public Town create(int cid, Town town);

	  public Town update(int cid, int tid, Town town);

	  public void destroy(int tid);

}
