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
public class Character {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String name;
	@Column(name="hp_max")
	private int hpMax;
	@Column(name="hp_curent")
	private int hpCurrent;
	private int intiative;
	private int ac;
	private int perception;
	private int investigation;
	private int insight;
	@Column(name="image_url")
	private String imageUrl;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "campign_id")
	private Campaign campaign;
	
	@OneToMany(mappedBy="character")
	private List<CharacterNote> characterNotes;
	
	//add and remove CharacterNotes from Character list
	
	public void addCharacterNote(CharacterNote characterNote) {
		if(characterNotes == null) characterNotes = new ArrayList<>();
		
		if(!characterNotes.contains(characterNote)) {
			characterNotes.add(characterNote);
			if(characterNote.getCharacter() != null) {
				characterNote.getCharacter().getCharacterNotes().remove(characterNote);
				
			}
			characterNote.setCharacter(this);
		}
	}
	
	public void removeCharacterNote(CharacterNote characterNote) {
		characterNote.setCharacter(null);
		if(characterNotes != null) {
			characterNotes.remove(characterNote);
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

	public int getHpMax() {
		return hpMax;
	}

	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}

	public int getHpCurrent() {
		return hpCurrent;
	}

	public void setHpCurrent(int hpCurrent) {
		this.hpCurrent = hpCurrent;
	}

	public int getIntiative() {
		return intiative;
	}

	public void setIntiative(int intiative) {
		this.intiative = intiative;
	}

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}

	public int getPerception() {
		return perception;
	}

	public void setPerception(int perception) {
		this.perception = perception;
	}

	public int getInvestigation() {
		return investigation;
	}

	public void setInvestigation(int investigation) {
		this.investigation = investigation;
	}

	public int getInsight() {
		return insight;
	}

	public void setInsight(int insight) {
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

	public List<CharacterNote> getCharacterNotes() {
		return characterNotes;
	}

	public void setCharacterNotes(List<CharacterNote> characterNotes) {
		this.characterNotes = characterNotes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ac;
		result = prime * result + ((campaign == null) ? 0 : campaign.hashCode());
		result = prime * result + ((characterNotes == null) ? 0 : characterNotes.hashCode());
		result = prime * result + hpCurrent;
		result = prime * result + hpMax;
		result = prime * result + id;
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + insight;
		result = prime * result + intiative;
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
		Character other = (Character) obj;
		if (ac != other.ac)
			return false;
		if (campaign == null) {
			if (other.campaign != null)
				return false;
		} else if (!campaign.equals(other.campaign))
			return false;
		if (characterNotes == null) {
			if (other.characterNotes != null)
				return false;
		} else if (!characterNotes.equals(other.characterNotes))
			return false;
		if (hpCurrent != other.hpCurrent)
			return false;
		if (hpMax != other.hpMax)
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
		if (intiative != other.intiative)
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
		builder.append("Character [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", hpMax=");
		builder.append(hpMax);
		builder.append(", hpCurrent=");
		builder.append(hpCurrent);
		builder.append(", intiative=");
		builder.append(intiative);
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
		builder.append(", characterNotes=");
		builder.append(characterNotes);
		builder.append("]");
		return builder.toString();
	}


	
	

}
