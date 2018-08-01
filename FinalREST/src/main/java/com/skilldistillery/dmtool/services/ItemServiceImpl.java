package com.skilldistillery.dmtool.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.dmtool.entities.Item;
import com.skilldistillery.dmtool.repositories.ItemRepository;
import com.skilldistillery.dmtool.repositories.UserRepository;
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepo;
	@Autowired
	private UserRepository userRepo;

	@Override
	public Set<Item> index(String email) {
		return (Set<Item>) itemRepo.findByUser_Email(email);
	}

	@Override
	public Item show(int iid) {
		return itemRepo.findById(iid).get();
	}

	@Override
	public Item create(String email, Item item) {
		item.setUser(userRepo.findOneByEmail(email));
		return itemRepo.saveAndFlush(item);
	}

	@Override
	public Item update(int iid, Item item) {
		item.setId(iid);
		return itemRepo.saveAndFlush(item);
	}

	@Override
	public void destroy(int iid) {
		itemRepo.deleteById(iid);
	}

}
