package com.skilldistillery.dmtool.services;

import java.util.List;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.dmtool.entities.Monster;
import com.skilldistillery.dmtool.entities.Spell;
import com.skilldistillery.dmtool.repositories.MonsterRepository;
import com.skilldistillery.dmtool.repositories.SpellRepository;
import com.skilldistillery.dmtool.repositories.UserRepository;
@Service
public class MonsterServiceImpl implements MonsterService {

	@Autowired
	private MonsterRepository monRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private SpellRepository spellRepo;
	
	//Find all by default Id then add in user created spells?
//	private List<Spell> spells = spellRepo.findAll();
			

	@Override
	public Set<Monster> index(String username) {
		Set<Monster> results = (Set<Monster>) monRepo.findByUser_Username(username);
		
		if(userRepo.findOneByUsername(username).getId() != 1) {
			results.addAll(index("admin"));
		}
		
		return results;
	}

	@Override
	public Monster show(int mid) {
		return monRepo.findById(mid).get();
	}

	@Override
	public Monster create(String username, Monster monster) {
		monster.setUser(userRepo.findOneByUsername(username));
		return monRepo.saveAndFlush(monster);
	}

	@Override
	public Monster update(String username, int mid, Monster monster) {
		if(monRepo.findById(mid).get().getUser().getId() == 1) {
			if(userRepo.findOneByUsername(username).getRole() == "admin") {
				monster.setUser(userRepo.findOneByUsername("admin"));
				monster.setId(mid);
				return monRepo.saveAndFlush(monster);
				
			}
			else {
				return create(username, monster);
			}
		}
		
		monster.setUser(userRepo.findOneByUsername(username));
		monster.setId(mid);
		return monRepo.saveAndFlush(monster);
	}

	@Override
	public void destroy(int mid) {
		monRepo.deleteById(mid);
	}
	
	public Monster addSpellObjects(Monster monster) {
		
		
		return monster;
		
	}
	@Override
	public boolean checkAbilityToModify(String username, int mid) {
		if(userRepo.findOneByUsername(username).getRole() == "admin") {
			return true;
		}
		if(userRepo.findOneByUsername(username).getId() == monRepo.findById(mid).get().getUser().getId()) {
			return true;
		}
		return false;
	}
}
