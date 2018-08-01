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
public class Town {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String name;
	private String description;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "campaign_id")
	private Campaign campaign;
	
//	@OneToMany(mappedBy="town")
//	private List<TownNote> townNotes;

	
	//add and remove CharacterNotes from Character list
	
//	public void addTownNote(TownNote townNote) {
//		if(townNotes == null) townNotes = new ArrayList<>();
//		
//		if(!townNotes.contains(townNote)) {
//			townNotes.add(townNote);
//			if(townNote.getTown() != null) {
//				townNote.getTown().getTownNotes().remove(townNote);
//				
//			}
//			townNote.setTown(this);
//		}
//	}
//	
//	public void removeTownNote(TownNote townNote) {
//		townNote.setTown(null);
//		if(townNotes != null) {
//			townNotes.remove(townNote);
//		}
//	}
	
	
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

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

//	public List<TownNote> getTownNotes() {
//		return townNotes;
//	}
//
//	public void setTownNotes(List<TownNote> townNotes) {
//		this.townNotes = townNotes;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campaign == null) ? 0 : campaign.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Town other = (Town) obj;
		if (campaign == null) {
			if (other.campaign != null)
				return false;
		} else if (!campaign.equals(other.campaign))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Town [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
	
	

}
