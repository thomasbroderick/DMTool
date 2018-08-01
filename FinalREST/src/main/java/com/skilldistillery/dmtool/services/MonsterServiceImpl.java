package com.skilldistillery.dmtool.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.dmtool.entities.Monster;
import com.skilldistillery.dmtool.entities.Spell;
import com.skilldistillery.dmtool.repositories.MonsterRepository;
import com.skilldistillery.dmtool.repositories.SpellRepository;
import com.skilldistillery.dmtool.repositories.UserRepository;

public class MonsterServiceImpl implements MonsterService {

	@Autowired
	private MonsterRepository monRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private SpellRepository spellRepo;
	
	//Find all by default Id then add in user created spells?
	private List<Spell> spells = spellRepo.findAll();
			

	@Override
	public Set<Monster> index(String email) {
		return (Set<Monster>) monRepo.findByUser_Email(email);
	}

	@Override
	public Monster show(int mid) {
		return monRepo.findById(mid).get();
	}

	@Override
	public Monster create(String email, Monster monster) {
		monster.setUser(userRepo.findOneByEmail(email));
		return monRepo.saveAndFlush(monster);
	}

	@Override
	public Monster update(int mid, Monster monster) {
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
}
