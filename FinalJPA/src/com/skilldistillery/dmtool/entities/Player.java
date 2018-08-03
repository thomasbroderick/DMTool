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
	private Integer level;
	private Integer perception;
	private Integer investigation;
	private Integer insight;
	@Column(name="image_url")
	private String imageUrl;
	private String profession;
	
	
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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<PlayerNote> getPlayerNotes() {
		return playerNotes;
	}

	public void setPlayerNotes(List<PlayerNote> playerNotes) {
		this.playerNotes = playerNotes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ac == null) ? 0 : ac.hashCode());
		result = prime * result + ((campaign == null) ? 0 : campaign.hashCode());
		result = prime * result + ((currentHp == null) ? 0 : currentHp.hashCode());
		result = prime * result + id;
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((initiative == null) ? 0 : initiative.hashCode());
		result = prime * result + ((insight == null) ? 0 : insight.hashCode());
		result = prime * result + ((investigation == null) ? 0 : investigation.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((maxHp == null) ? 0 : maxHp.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((perception == null) ? 0 : perception.hashCode());
		result = prime * result + ((playerNotes == null) ? 0 : playerNotes.hashCode());
		result = prime * result + ((profession == null) ? 0 : profession.hashCode());
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
		if (ac == null) {
			if (other.ac != null)
				return false;
		} else if (!ac.equals(other.ac))
			return false;
		if (campaign == null) {
			if (other.campaign != null)
				return false;
		} else if (!campaign.equals(other.campaign))
			return false;
		if (currentHp == null) {
			if (other.currentHp != null)
				return false;
		} else if (!currentHp.equals(other.currentHp))
			return false;
		if (id != other.id)
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (initiative == null) {
			if (other.initiative != null)
				return false;
		} else if (!initiative.equals(other.initiative))
			return false;
		if (insight == null) {
			if (other.insight != null)
				return false;
		} else if (!insight.equals(other.insight))
			return false;
		if (investigation == null) {
			if (other.investigation != null)
				return false;
		} else if (!investigation.equals(other.investigation))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (maxHp == null) {
			if (other.maxHp != null)
				return false;
		} else if (!maxHp.equals(other.maxHp))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (perception == null) {
			if (other.perception != null)
				return false;
		} else if (!perception.equals(other.perception))
			return false;
		if (playerNotes == null) {
			if (other.playerNotes != null)
				return false;
		} else if (!playerNotes.equals(other.playerNotes))
			return false;
		if (profession == null) {
			if (other.profession != null)
				return false;
		} else if (!profession.equals(other.profession))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", maxHp=");
		builder.append(maxHp);
		builder.append(", currentHp=");
		builder.append(currentHp);
		builder.append(", initiative=");
		builder.append(initiative);
		builder.append(", ac=");
		builder.append(ac);
		builder.append(", level=");
		builder.append(level);
		builder.append(", perception=");
		builder.append(perception);
		builder.append(", investigation=");
		builder.append(investigation);
		builder.append(", insight=");
		builder.append(insight);
		builder.append(", imageUrl=");
		builder.append(imageUrl);
		builder.append(", profession=");
		builder.append(profession);
		builder.append(", playerNotes=");
		builder.append(playerNotes);
		builder.append("]");
		return builder.toString();
	}



	
	

}
