package com.skilldistillery.dmtool.services;

import java.util.Set;

import com.skilldistillery.dmtool.entities.Monster;

public interface MonsterService {
	  public Set<Monster> index(String email);

	  public Monster show(int mid);

	  public Monster create(String email, Monster monster);

	  public Monster update(int mid, Monster monster);

	  public void destroy(int mid);
}
