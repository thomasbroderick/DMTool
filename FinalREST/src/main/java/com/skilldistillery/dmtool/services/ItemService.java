package com.skilldistillery.dmtool.services;

import java.util.Set;

import com.skilldistillery.dmtool.entities.Item;

public interface ItemService {
	  public Set<Item> index(String username);

	  public Item show(String username, int iid);

	  public Item create(String username, Item item);

	  public Item update(String username, int iid, Item item);

	  public void destroy(String username, int iid);
}
