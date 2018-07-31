package com.skilldistillery.dmtool.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Monster {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String name;
	private String size;
	private String type;
	private String subtype;
	private String alignment;
	@Column(name="damage_vulnerabilities")
	private String vulnerabilities;
	@Column(name="damage_resistances")
	private String resistances;
	@Column(name="damage_immunities")
	private String immunnities;
	@Column(name="condition_immunities")
	private String conditionImmunities;
	private String senses;
	private String languages;
	@Column(name="special_abilities")
	private String specialAbilities;
	private String actions;
	@Column(name="legendary_actions")
	private String legendaryActions;
	@Column(name="image_url")
	private String imageUrl;
	@Column(name="hit_dice")
	private String hitDice;
	@Column(name="armor_class")
	private int ac;
	private int stealth;
	@Column(name="hit_points")
	private int hitPoints;
	private String speed;
	private int strength;
	private int dexterity;
	private int intelligence;
	private int wisdom;
	private int charisma;
	private int constitution;
	@Column(name="challenge_rating")
	private int challengeRating;
	@Column(name="dexterity_save")
	private int dexteritySave;
	@Column(name="constitution_save")
	private int constitutionSave;
	@Column(name="wisdom_save")
	private int wisdomSave;
	@Column(name="charisma_save")
	private int charismaSave;	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public String getVulnerabilities() {
		return vulnerabilities;
	}

	public void setVulnerabilities(String vulnerabilities) {
		this.vulnerabilities = vulnerabilities;
	}

	public String getResistances() {
		return resistances;
	}

	public void setResistances(String resistances) {
		this.resistances = resistances;
	}

	public String getImmunnities() {
		return immunnities;
	}

	public void setImmunnities(String immunnities) {
		this.immunnities = immunnities;
	}

	public String getConditionImmunities() {
		return conditionImmunities;
	}

	public void setConditionImmunities(String conditionImmunities) {
		this.conditionImmunities = conditionImmunities;
	}

	public String getSenses() {
		return senses;
	}

	public void setSenses(String senses) {
		this.senses = senses;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getSpecialAbilities() {
		return specialAbilities;
	}

	public void setSpecialAbilities(String specialAbilities) {
		this.specialAbilities = specialAbilities;
	}

	public String getActions() {
		return actions;
	}

	public void setActions(String actions) {
		this.actions = actions;
	}

	public String getLegendaryActions() {
		return legendaryActions;
	}

	public void setLegendaryActions(String legendaryActions) {
		this.legendaryActions = legendaryActions;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getHitDice() {
		return hitDice;
	}

	public void setHitDice(String hitDice) {
		this.hitDice = hitDice;
	}

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}

	public int getStealth() {
		return stealth;
	}

	public void setStealth(int stealth) {
		this.stealth = stealth;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public int getChallengeRating() {
		return challengeRating;
	}

	public void setChallengeRating(int challengeRating) {
		this.challengeRating = challengeRating;
	}

	public int getDexteritySave() {
		return dexteritySave;
	}

	public void setDexteritySave(int dexteritySave) {
		this.dexteritySave = dexteritySave;
	}

	public int getConstitutionSave() {
		return constitutionSave;
	}

	public void setConstitutionSave(int constitutionSave) {
		this.constitutionSave = constitutionSave;
	}

	public int getWisdomSave() {
		return wisdomSave;
	}

	public void setWisdomSave(int wisdomSave) {
		this.wisdomSave = wisdomSave;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getCharismaSave() {
		return charismaSave;
	}

	public void setCharismaSave(int charismaSave) {
		this.charismaSave = charismaSave;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ac;
		result = prime * result + ((actions == null) ? 0 : actions.hashCode());
		result = prime * result + ((alignment == null) ? 0 : alignment.hashCode());
		result = prime * result + challengeRating;
		result = prime * result + charisma;
		result = prime * result + charismaSave;
		result = prime * result + ((conditionImmunities == null) ? 0 : conditionImmunities.hashCode());
		result = prime * result + constitution;
		result = prime * result + constitutionSave;
		result = prime * result + dexterity;
		result = prime * result + dexteritySave;
		result = prime * result + ((hitDice == null) ? 0 : hitDice.hashCode());
		result = prime * result + hitPoints;
		result = prime * result + id;
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((immunnities == null) ? 0 : immunnities.hashCode());
		result = prime * result + intelligence;
		result = prime * result + ((languages == null) ? 0 : languages.hashCode());
		result = prime * result + ((legendaryActions == null) ? 0 : legendaryActions.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((resistances == null) ? 0 : resistances.hashCode());
		result = prime * result + ((senses == null) ? 0 : senses.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((specialAbilities == null) ? 0 : specialAbilities.hashCode());
		result = prime * result + ((speed == null) ? 0 : speed.hashCode());
		result = prime * result + stealth;
		result = prime * result + strength;
		result = prime * result + ((subtype == null) ? 0 : subtype.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((vulnerabilities == null) ? 0 : vulnerabilities.hashCode());
		result = prime * result + wisdom;
		result = prime * result + wisdomSave;
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
		Monster other = (Monster) obj;
		if (ac != other.ac)
			return false;
		if (actions == null) {
			if (other.actions != null)
				return false;
		} else if (!actions.equals(other.actions))
			return false;
		if (alignment == null) {
			if (other.alignment != null)
				return false;
		} else if (!alignment.equals(other.alignment))
			return false;
		if (challengeRating != other.challengeRating)
			return false;
		if (charisma != other.charisma)
			return false;
		if (charismaSave != other.charismaSave)
			return false;
		if (conditionImmunities == null) {
			if (other.conditionImmunities != null)
				return false;
		} else if (!conditionImmunities.equals(other.conditionImmunities))
			return false;
		if (constitution != other.constitution)
			return false;
		if (constitutionSave != other.constitutionSave)
			return false;
		if (dexterity != other.dexterity)
			return false;
		if (dexteritySave != other.dexteritySave)
			return false;
		if (hitDice == null) {
			if (other.hitDice != null)
				return false;
		} else if (!hitDice.equals(other.hitDice))
			return false;
		if (hitPoints != other.hitPoints)
			return false;
		if (id != other.id)
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (immunnities == null) {
			if (other.immunnities != null)
				return false;
		} else if (!immunnities.equals(other.immunnities))
			return false;
		if (intelligence != other.intelligence)
			return false;
		if (languages == null) {
			if (other.languages != null)
				return false;
		} else if (!languages.equals(other.languages))
			return false;
		if (legendaryActions == null) {
			if (other.legendaryActions != null)
				return false;
		} else if (!legendaryActions.equals(other.legendaryActions))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (resistances == null) {
			if (other.resistances != null)
				return false;
		} else if (!resistances.equals(other.resistances))
			return false;
		if (senses == null) {
			if (other.senses != null)
				return false;
		} else if (!senses.equals(other.senses))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (specialAbilities == null) {
			if (other.specialAbilities != null)
				return false;
		} else if (!specialAbilities.equals(other.specialAbilities))
			return false;
		if (speed == null) {
			if (other.speed != null)
				return false;
		} else if (!speed.equals(other.speed))
			return false;
		if (stealth != other.stealth)
			return false;
		if (strength != other.strength)
			return false;
		if (subtype == null) {
			if (other.subtype != null)
				return false;
		} else if (!subtype.equals(other.subtype))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (vulnerabilities == null) {
			if (other.vulnerabilities != null)
				return false;
		} else if (!vulnerabilities.equals(other.vulnerabilities))
			return false;
		if (wisdom != other.wisdom)
			return false;
		if (wisdomSave != other.wisdomSave)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Monster [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", size=");
		builder.append(size);
		builder.append(", type=");
		builder.append(type);
		builder.append(", subtype=");
		builder.append(subtype);
		builder.append(", alignment=");
		builder.append(alignment);
		builder.append(", vulnerabilities=");
		builder.append(vulnerabilities);
		builder.append(", resistances=");
		builder.append(resistances);
		builder.append(", immunnities=");
		builder.append(immunnities);
		builder.append(", conditionImmunities=");
		builder.append(conditionImmunities);
		builder.append(", senses=");
		builder.append(senses);
		builder.append(", languages=");
		builder.append(languages);
		builder.append(", specialAbilities=");
		builder.append(specialAbilities);
		builder.append(", actions=");
		builder.append(actions);
		builder.append(", legendaryActions=");
		builder.append(legendaryActions);
		builder.append(", imageUrl=");
		builder.append(imageUrl);
		builder.append(", hitDice=");
		builder.append(hitDice);
		builder.append(", ac=");
		builder.append(ac);
		builder.append(", stealth=");
		builder.append(stealth);
		builder.append(", hitPoints=");
		builder.append(hitPoints);
		builder.append(", speed=");
		builder.append(speed);
		builder.append(", strength=");
		builder.append(strength);
		builder.append(", dexterity=");
		builder.append(dexterity);
		builder.append(", intelligence=");
		builder.append(intelligence);
		builder.append(", wisdom=");
		builder.append(wisdom);
		builder.append(", charisma=");
		builder.append(charisma);
		builder.append(", constitution=");
		builder.append(constitution);
		builder.append(", challengeRating=");
		builder.append(challengeRating);
		builder.append(", dexteritySave=");
		builder.append(dexteritySave);
		builder.append(", constitutionSave=");
		builder.append(constitutionSave);
		builder.append(", wisdomSave=");
		builder.append(wisdomSave);
		builder.append(", charismaSave=");
		builder.append(charismaSave);
		builder.append("]");
		return builder.toString();
	}


	

	

	
}
