package com.skilldistillery.dmtool.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Player {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String name;
	@Column(name="max_hp")
	private Integer maxHp;
	@Column(name="current_hp")
	private Integer currentHp;
	private Integer initiative;
	private Integer ac;
	private Integer perception;
	private Integer investigation;
	private Integer insight;
	@Column(name="image_url")
	private String imageUrl;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "campaign_id")
	private Campaign campaign;
	
	@OneToMany(mappedBy="player")
	private List<PlayerNote> playerNotes;
	
	//add and remove playerNotes from player list
	
	public void addPlayerNote(PlayerNote playerNote) {
		if(playerNotes == null) playerNotes = new ArrayList<>();
		
		if(!playerNotes.contains(playerNote)) {
			playerNotes.add(playerNote);
			if(playerNote.getPlayer() != null) {
				playerNote.getPlayer().getPlayerNotes().remove(playerNote);
				
			}
			playerNote.setPlayer(this);
		}
	}
	
	public void removePlayerNote(PlayerNote playerNote) {
		playerNote.setPlayer(null);
		if(playerNotes != null) {
			playerNotes.remove(playerNote);
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(Integer hpMax) {
		this.maxHp = hpMax;
	}

	public Integer getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(Integer hpCurrent) {
		this.currentHp = hpCurrent;
	}

	public Integer getInitiative() {
		return initiative;
	}

	public void setInitiative(Integer Initiative) {
		this.initiative = Initiative;
	}

	public Integer getAc() {
		return ac;
	}

	public void setAc(Integer ac) {
		this.ac = ac;
	}

	public Integer getPerception() {
		return perception;
	}

	public void setPerception(Integer perception) {
		this.perception = perception;
	}

	public Integer getInvestigation() {
		return investigation;
	}

	public void setInvestigation(Integer investigation) {
		this.investigation = investigation;
	}

	public Integer getInsight() {
		return insight;
	}

	public void setInsight(Integer insight) {
		this.insight = insight;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public List<PlayerNote> getPlayerNotes() {
		return playerNotes;
	}

	public void setPlayerNotes(List<PlayerNote> playerNotes) {
		this.playerNotes = playerNotes;
	}

	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
		result = prime * result + ac;
		result = prime * result + ((campaign == null) ? 0 : campaign.hashCode());
		result = prime * result + ((playerNotes == null) ? 0 : playerNotes.hashCode());
		result = prime * result + currentHp;
		result = prime * result + maxHp;
		result = prime * result + id;
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + insight;
		result = prime * result + initiative;
		result = prime * result + investigation;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + perception;
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
		Player other = (Player) obj;
		if (ac != other.ac)
			return false;
		if (campaign == null) {
			if (other.campaign != null)
				return false;
		} else if (!campaign.equals(other.campaign))
			return false;
		if (playerNotes == null) {
			if (other.playerNotes != null)
				return false;
		} else if (!playerNotes.equals(other.playerNotes))
			return false;
		if (currentHp != other.currentHp)
			return false;
		if (maxHp != other.maxHp)
			return false;
		if (id != other.id)
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (insight != other.insight)
			return false;
		if (initiative != other.initiative)
			return false;
		if (investigation != other.investigation)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (perception != other.perception)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("player [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", hpMax=");
		builder.append(maxHp);
		builder.append(", hpCurrent=");
		builder.append(currentHp);
		builder.append(", intiative=");
		builder.append(initiative);
		builder.append(", ac=");
		builder.append(ac);
		builder.append(", perception=");
		builder.append(perception);
		builder.append(", investigation=");
		builder.append(investigation);
		builder.append(", insight=");
		builder.append(insight);
		builder.append(", imageUrl=");
		builder.append(imageUrl);
		builder.append(", playerNotes=");
		builder.append(playerNotes);
		builder.append("]");
		return builder.toString();
	}


	
	

}
