package com.skilldistillery.dmtool.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "email")
	private String username;
	private String password;
	private boolean enabled;
	private String role;
	
	@OneToMany(mappedBy="user")
	private List<Spell> spells;
	
	@OneToMany(mappedBy="user")
	private List<Monster> monsters;
	
	//one to one for settings
	
	@OneToMany(mappedBy="user")
	private List<Campaign> campaigns;
	
	@OneToMany(mappedBy="user")
	private List<Item> items;
	
	
	//add and remove Spells from User list
	
	public void addSpell(Spell spell) {
		if(spells == null) spells = new ArrayList<>();
		
		if(!spells.contains(spell)) {
			spells.add(spell);
			if(spell.getUser() != null) {
				spell.getUser().getSpells().remove(spell);
				
			}
			spell.setUser(this);
		}
	}
	
	public void removeSpell(Spell spell) {
		spell.setUser(null);
		if(spells != null) {
			spells.remove(spell);
		}
	}
	//add and remove Monsters from User list
	
	public void addMonster(Monster monster) {
		if(monsters == null) monsters = new ArrayList<>();
		
		if(!monsters.contains(monster)) {
			monsters.add(monster);
			if(monster.getUser() != null) {
				monster.getUser().getMonsters().remove(monster);
				
			}
			monster.setUser(this);
		}
	}
	
	public void removeMonster(Monster monster) {
		monster.setUser(null);
		if(monsters != null) {
			monsters.remove(monster);
		}
	}
		
		//add and remove campigns from user list
		
		public void addCampaign(Campaign campaign) {
			if(campaigns == null) campaigns = new ArrayList<>();
			
			if(!campaigns.contains(campaign)) {
				campaigns.add(campaign);
				if(campaign.getUser() != null) {
					campaign.getUser().getCampaigns().remove(campaign);
					
				}
				campaign.setUser(this);
			}
		}
		
		public void removeCampaign(Campaign campaign) {
			campaign.setUser(null);
			if(campaigns != null) {
				campaigns.remove(campaign);
			}
		}
		

		//add and remove items from user list
		
		public void addItem(Item item) {
			if(items == null) items = new ArrayList<>();
			
			if(!items.contains(item)) {
				items.add(item);
				if(item.getUser() != null) {
					item.getUser().getItems().remove(item);
					
				}
				item.setUser(this);
			}
		}
		
		public void removeItem(Item item) {
			item.setUser(null);
			if(items != null) {
				items.remove(item);
			}
		}
		
		
		
	
	//getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Spell> getSpells() {
		return spells;
	}

	public void setSpells(List<Spell> spells) {
		this.spells = spells;
	}

	public List<Monster> getMonsters() {
		return monsters;
	}

	public void setMonsters(List<Monster> monsters) {
		this.monsters = monsters;
	}

	public List<Campaign> getCampaigns() {
		return campaigns;
	}

	public void setCampaigns(List<Campaign> campaigns) {
		this.campaigns = campaigns;
	}


	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campaigns == null) ? 0 : campaigns.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((monsters == null) ? 0 : monsters.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((spells == null) ? 0 : spells.hashCode());
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
		User other = (User) obj;
		if (campaigns == null) {
			if (other.campaigns != null)
				return false;
		} else if (!campaigns.equals(other.campaigns))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (enabled != other.enabled)
			return false;
		if (id != other.id)
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (monsters == null) {
			if (other.monsters != null)
				return false;
		} else if (!monsters.equals(other.monsters))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (spells == null) {
			if (other.spells != null)
				return false;
		} else if (!spells.equals(other.spells))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", enabled=");
		builder.append(enabled);
		builder.append(", role=");
		builder.append(role);
		builder.append(", spells=");
		builder.append(spells);
		builder.append(", monsters=");
		builder.append(monsters);
		builder.append(", campaigns=");
		builder.append(campaigns);
		builder.append(", items=");
		builder.append(items);
		builder.append("]");
		return builder.toString();
	}

	}
