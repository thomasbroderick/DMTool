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


@Entity
public class Campaign {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String name;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy="campaign")
	private List<Npc> npcs;
	@OneToMany(mappedBy="campaign")
	private List<Town> towns;
	@OneToMany(mappedBy="campaign")
	private List<Player> players;

	
	
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
	
	public void addPlayer(Player player) {
		if(players == null) players = new ArrayList<>();
		
		if(!players.contains(player)) {
			players.add(player);
			if(player.getCampaign() != null) {
				player.getCampaign().getPlayers().remove(player);
				
			}
			player.setCampaign(this);
		}
	}
	
	public void removePlayer(Player player) {
		player.setCampaign(null);
		if(players != null) {
			players.remove(player);
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

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((npcs == null) ? 0 : npcs.hashCode());
		result = prime * result + ((players == null) ? 0 : players.hashCode());
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
		if (players == null) {
			if (other.players != null)
				return false;
		} else if (!players.equals(other.players))
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
		builder.append(", players=");
		builder.append(players);
		builder.append("]");
		return builder.toString();
	}
	
}
