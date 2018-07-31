package com.skilldistillery.dmtool.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Npc {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String name;
	private String description;
	@Column(name="image_url")
	private String imageUrl;	
	@ManyToOne
	@JoinColumn(name="monster_id")
	private Monster monster;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="campaign_id")
	private Campaign campaign;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Monster getMonster() {
		return monster;
	}
	public void setMonster(Monster monster) {
		this.monster = monster;
	}
	public Campaign getCampaign() {
		return campaign;
	}
	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Npc [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", imageUrl=");
		builder.append(imageUrl);
		builder.append(", monster=");
		builder.append(monster);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
