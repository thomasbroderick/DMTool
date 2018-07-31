package com.skilldistillery.dmtool.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Spell {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String name;
	private String description;
	@Column(name="higher_lvl")
	private String higherLevel;
	private String range;
	private String components;
	private String material;
	private String ritual;
	private String duration;
	private String concentration;
	@Column(name="casting_time")
	private String castingTime;
	private String level;
	private String school;
	private String classes;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	//getters and setters
	
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

	public String getHigherLevel() {
		return higherLevel;
	}

	public void setHigherLevel(String higherLevel) {
		this.higherLevel = higherLevel;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getComponents() {
		return components;
	}

	public void setComponents(String components) {
		this.components = components;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getRitual() {
		return ritual;
	}

	public void setRitual(String ritual) {
		this.ritual = ritual;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getConcentration() {
		return concentration;
	}

	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}

	public String getCastingTime() {
		return castingTime;
	}

	public void setCastingTime(String castingTime) {
		this.castingTime = castingTime;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String lvl) {
		this.level = lvl;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((castingTime == null) ? 0 : castingTime.hashCode());
		result = prime * result + ((classes == null) ? 0 : classes.hashCode());
		result = prime * result + ((components == null) ? 0 : components.hashCode());
		result = prime * result + ((concentration == null) ? 0 : concentration.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((higherLevel == null) ? 0 : higherLevel.hashCode());
		result = prime * result + id;
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		result = prime * result + ((range == null) ? 0 : range.hashCode());
		result = prime * result + ((ritual == null) ? 0 : ritual.hashCode());
		result = prime * result + ((school == null) ? 0 : school.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Spell other = (Spell) obj;
		if (castingTime == null) {
			if (other.castingTime != null)
				return false;
		} else if (!castingTime.equals(other.castingTime))
			return false;
		if (classes == null) {
			if (other.classes != null)
				return false;
		} else if (!classes.equals(other.classes))
			return false;
		if (components == null) {
			if (other.components != null)
				return false;
		} else if (!components.equals(other.components))
			return false;
		if (concentration == null) {
			if (other.concentration != null)
				return false;
		} else if (!concentration.equals(other.concentration))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (higherLevel == null) {
			if (other.higherLevel != null)
				return false;
		} else if (!higherLevel.equals(other.higherLevel))
			return false;
		if (id != other.id)
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (range == null) {
			if (other.range != null)
				return false;
		} else if (!range.equals(other.range))
			return false;
		if (ritual == null) {
			if (other.ritual != null)
				return false;
		} else if (!ritual.equals(other.ritual))
			return false;
		if (school == null) {
			if (other.school != null)
				return false;
		} else if (!school.equals(other.school))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		builder.append("Spell [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", higherLevel=");
		builder.append(higherLevel);
		builder.append(", range=");
		builder.append(range);
		builder.append(", components=");
		builder.append(components);
		builder.append(", material=");
		builder.append(material);
		builder.append(", ritual=");
		builder.append(ritual);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", concentration=");
		builder.append(concentration);
		builder.append(", castingTime=");
		builder.append(castingTime);
		builder.append(", lvl=");
		builder.append(level);
		builder.append(", school=");
		builder.append(school);
		builder.append(", classes=");
		builder.append(classes);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
