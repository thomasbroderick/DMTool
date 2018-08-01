package com.skilldistillery.dmtool.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.dmtool.entities.Spell;
import com.skilldistillery.dmtool.repositories.SpellRepository;
import com.skilldistillery.dmtool.repositories.UserRepository;

public class SpellServiceImpl implements SpellService {
	
	@Autowired
	private SpellRepository spellRepo;
	@Autowired
	private UserRepository userRepo;

	@Override
	public Set<Spell> index(String email) {
		return (Set<Spell>) spellRepo.findByUser_Email(email);
	}

	@Override
	public Spell show(int sid) {
		return spellRepo.findById(sid).get();
	}

	@Override
	public Spell create(String email, Spell spell) {
		spell.setUser(userRepo.findOneByEmail(email));
		return spellRepo.saveAndFlush(spell);
	}

	@Override
	public Spell update(int sid, Spell spell) {
		spell.setId(sid);
		return spellRepo.saveAndFlush(spell);
	}

	@Override
	public void destroy(int sid) {
		spellRepo.deleteById(sid);
	}

}
