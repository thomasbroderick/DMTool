package com.skilldistillery.dmtool.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Campaign {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String name;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy="campaign")
	private List<Npc> npcs;
	@OneToMany(mappedBy="campaign")
	private List<Town> towns;
	@OneToMany(mappedBy="campaign")
	private List<Character> characters;

	
	
	//add and remove NPCs from campaign list
	
	public void addNpc(Npc npc) {
		if(npcs == null) npcs = new ArrayList<>();
		
		if(!npcs.contains(npc)) {
			npcs.add(npc);
			if(npc.getCampaign() != null) {
				npc.getCampaign().getNpcs().remove(npc);
				
			}
			npc.setCampaign(this);
		}
	}
	
	public void removeNpc(Npc npc) {
		npc.setCampaign(null);
		if(npcs != null) {
			npcs.remove(npc);
		}
	}
	
	//add and remove Towns from campaign list
	
	public void addTown(Town town) {
		if(towns == null) towns = new ArrayList<>();
		
		if(!towns.contains(town)) {
			towns.add(town);
			if(town.getCampaign() != null) {
				town.getCampaign().getTowns().remove(town);
				
			}
			town.setCampaign(this);
		}
	}
	
	public void removeTown(Town town) {
		town.setCampaign(null);
		if(towns != null) {
			towns.remove(town);
		}
	}
	
	//add and remove Charasters from campaign list
	
	public void addCharacter(Character character) {
		if(characters == null) characters = new ArrayList<>();
		
		if(!characters.contains(character)) {
			characters.add(character);
			if(character.getCampaign() != null) {
				character.getCampaign().getCharacters().remove(character);
				
			}
			character.setCampaign(this);
		}
	}
	
	public void removeCharacter(Character character) {
		character.setCampaign(null);
		if(characters != null) {
			characters.remove(character);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Npc> getNpcs() {
		return npcs;
	}

	public void setNpcs(List<Npc> npcs) {
		this.npcs = npcs;
	}

	public List<Town> getTowns() {
		return towns;
	}

	public void setTowns(List<Town> towns) {
		this.towns = towns;
	}

	public List<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((characters == null) ? 0 : characters.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((npcs == null) ? 0 : npcs.hashCode());
		result = prime * result + ((towns == null) ? 0 : towns.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campaign other = (Campaign) obj;
		if (characters == null) {
			if (other.characters != null)
				return false;
		} else if (!characters.equals(other.characters))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (npcs == null) {
			if (other.npcs != null)
				return false;
		} else if (!npcs.equals(other.npcs))
			return false;
		if (towns == null) {
			if (other.towns != null)
				return false;
		} else if (!towns.equals(other.towns))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Campaign [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", npcs=");
		builder.append(npcs);
		builder.append(", towns=");
		builder.append(towns);
		builder.append(", characters=");
		builder.append(characters);
		builder.append("]");
		return builder.toString();
	}
	
}
