package com.skilldistillery.dmtool.services;

import java.util.ArrayList;
import java.util.List;
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

	private boolean needsFix = true;

	@Override
	public Set<Item> index(String username) {
		Set<Item> results = (Set<Item>) itemRepo.findByUser_Username(username);

		if (userRepo.findOneByUsername(username).getId() != 1) {
			results.addAll(index("admin"));
		}
		fix(results);
		return results;
	}

	public void fix(Set<Item> results) {
		List<Item> fixMe = new ArrayList<>(results);

		for (int i = 0; i < results.size(); i++) {
			Item item = fixMe.get(i);
			StringBuilder strb = new StringBuilder();
			String str = item.getProperties();

			if (str.contains("Ammunition"))
				strb.append("Ammunition, ");
			if (str.contains("Finesse"))
				strb.append("Finesse, ");
			if (str.contains("Heavy"))
				strb.append("Heavy, ");
			if (str.contains("Light"))
				strb.append("Light, ");
			if (str.contains("Loading"))
				strb.append("Loading, ");
			if (str.contains("Reach"))
				strb.append("Reach, ");
			if (str.contains("Special"))
				strb.append("Special, ");
			if (str.contains("Thrown"))
				strb.append("Thrown, ");
			if (str.contains("Two-Handed"))
				strb.append("Two-Handed, ");
			if (str.contains("Versatile"))
				strb.append("Versatile, ");
			if (str.contains("Monk"))
				strb.append("Monk, ");

			if (strb.length() > 0) {
				strb.deleteCharAt(strb.length() - 2);
			}
			item.setProperties(strb.toString());

			update("admin", item.getId(), item);
			needsFix = false;
		}
	}

	@Override
	public Item show(int iid) {
		return itemRepo.findById(iid).get();
	}

	@Override
	public Item create(String username, Item item) {
		item.setUser(userRepo.findOneByUsername(username));
		return itemRepo.saveAndFlush(item);
	}

	@Override
	public Item update(String username, int iid, Item item) {
		if (itemRepo.findById(iid).get().getUser().getId() == 1) {
			if (userRepo.findOneByUsername(username).getRole() == "admin") {
				item.setUser(userRepo.findOneByUsername("admin"));
				item.setId(iid);
				return itemRepo.saveAndFlush(item);

			} else {
				return create(username, item);
			}
		}

		item.setUser(userRepo.findOneByUsername(username));
		item.setId(iid);
		return itemRepo.saveAndFlush(item);
	}

	@Override
	public void destroy(int iid) {
		itemRepo.deleteById(iid);
	}

	@Override
	public boolean checkAbilityToModify(String username, int mid) {
		if (userRepo.findOneByUsername(username).getRole() == "admin") {
			return true;
		}
		if (userRepo.findOneByUsername(username).getId() == itemRepo.findById(mid).get().getUser().getId()) {
			return true;
		}
		return false;
	}

}
