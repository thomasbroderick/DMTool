package com.skilldistillery.dmtool.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.dmtool.entities.Monster;
import com.skilldistillery.dmtool.entities.Spell;
import com.skilldistillery.dmtool.repositories.SpellRepository;
import com.skilldistillery.dmtool.repositories.UserRepository;
@Service
public class SpellServiceImpl implements SpellService {
	
	@Autowired
	private SpellRepository spellRepo;
	@Autowired
	private UserRepository userRepo;

	@Override
	public Set<Spell> index(String username) {
		Set<Spell> results = (Set<Spell>) spellRepo.findByUser_Username(username);
		
		if(userRepo.findOneByUsername(username).getId() != 1) {
			results.addAll(index("admin@admin.com"));
		}	
		return results;
	}

	@Override
	public Spell show(int sid) {
		return spellRepo.findById(sid).get();
	}

	@Override
	public Spell create(String username, Spell spell) {
		spell.setUser(userRepo.findOneByUsername(username));
		return spellRepo.saveAndFlush(spell);
	}

	@Override
	public Spell update(String username, int sid, Spell spell) {
		spell.setId(sid);
		spell.setUser(userRepo.findOneByUsername(username));
		return spellRepo.saveAndFlush(spell);
	}

	@Override
	public void destroy(int sid) {
		spellRepo.deleteById(sid);
	}

}
