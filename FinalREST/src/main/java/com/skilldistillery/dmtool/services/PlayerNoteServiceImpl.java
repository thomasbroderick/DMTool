package com.skilldistillery.dmtool.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.dmtool.entities.PlayerNote;
import com.skilldistillery.dmtool.repositories.PlayerNoteRepository;
import com.skilldistillery.dmtool.repositories.PlayerRepository;
@Service
public class PlayerNoteServiceImpl implements PlayerNoteService {
	
	@Autowired
	private PlayerNoteRepository noteRepo;
	@Autowired
	private PlayerRepository playerRepo;

	@Override
	public Set<PlayerNote> index(int pid) {
		return (Set<PlayerNote>) noteRepo.findByPlayer_Id(pid);
	}

	@Override
	public PlayerNote show(int pid) {
		return noteRepo.findById(pid).get();
	}

	@Override
	public PlayerNote create(int pid, PlayerNote playerNote) {
		playerNote.setPlayer(playerRepo.findById(pid).get());
		return noteRepo.saveAndFlush(playerNote);
	}

	@Override
	public PlayerNote update(int pid, PlayerNote playerNote) {
		playerNote.setId(pid);
		return noteRepo.saveAndFlush(playerNote);
	}

	@Override
	public void destroy(int mid) {
		noteRepo.deleteById(mid);
	}

}
