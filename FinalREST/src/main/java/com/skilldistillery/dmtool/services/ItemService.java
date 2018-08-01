package com.skilldistillery.dmtool.services;

import java.util.Set;

import com.skilldistillery.dmtool.entities.Item;

public interface ItemService {
	  public Set<Item> index(String email);

	  public Item show(int iid);

	  public Item create(String email, Item item);

	  public Item update(String email, int iid, Item item);

	  public void destroy(int iid);

	
}
