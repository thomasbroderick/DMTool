package com.skilldistillery.dmtool.services;

import java.util.Set;

import com.skilldistillery.dmtool.entities.Monster;

public interface MonsterService {
	  public Set<Monster> index(String username);

	  public Monster show(String username, int mid);

	  public Monster create(String username, Monster monster);

	  public Monster update(String username, int mid, Monster monster);

	  public void destroy(String username, int mid);
}
