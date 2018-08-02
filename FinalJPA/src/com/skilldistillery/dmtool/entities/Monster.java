package com.skilldistillery.dmtool.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Monster {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String name;
	private String size;
	private String type;
	private String subtype;
	private String alignment;
	@Column(name="damage_vulnerabilities")
	private String damageVulnerabilities;
	@Column(name="damage_resistances")
	private String damageResistances;
	@Column(name="damage_immunities")
	private String damageImmunities;
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
	private Integer ac;
	private Integer stealth;
	@Column(name="hit_points")
	private Integer hitPoints;
	private String speed;
	private Integer strength;
	private Integer dexterity;
	private Integer intelligence;
	private Integer wisdom;
	private Integer charisma;
	private Integer constitution;
	@Column(name="challenge_rating")
	private String challengeRating;
	@Column(name="dexterity_save")
	private Integer dexteritySave;
	@Column(name="wisdom_save")
	private Integer wisdomSave;
	@Column(name="charisma_save")
	private Integer charismaSave;	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

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
		return damageVulnerabilities;
	}

	public void setVulnerabilities(String vulnerabilities) {
		this.damageVulnerabilities = vulnerabilities;
	}

	public String getResistances() {
		return damageResistances;
	}

	public void setResistances(String resistances) {
		this.damageResistances = resistances;
	}

	public String getImmunnities() {
		return damageImmunities;
	}

	public void setImmunnities(String immunnities) {
		this.damageImmunities = immunnities;
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

	public Integer getAc() {
		return ac;
	}

	public void setAc(Integer ac) {
		this.ac = ac;
	}

	public Integer getStealth() {
		return stealth;
	}

	public void setStealth(Integer stealth) {
		this.stealth = stealth;
	}

	public Integer getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(Integer hitPoints) {
		this.hitPoints = hitPoints;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getDexterity() {
		return dexterity;
	}

	public void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}

	public Integer getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}

	public Integer getWisdom() {
		return wisdom;
	}

	public void setWisdom(Integer wisdom) {
		this.wisdom = wisdom;
	}

	public Integer getCharisma() {
		return charisma;
	}

	public void setCharisma(Integer charisma) {
		this.charisma = charisma;
	}

	public Integer getConstitution() {
		return constitution;
	}

	public void setConstitution(Integer constitution) {
		this.constitution = constitution;
	}

	public String getChallengeRating() {
		return challengeRating;
	}

	public void setChallengeRating(String challengeRating) {
		this.challengeRating = challengeRating;
	}

	public Integer getDexteritySave() {
		return dexteritySave;
	}

	public void setDexteritySave(Integer dexteritySave) {
		this.dexteritySave = dexteritySave;
	}


	public Integer getWisdomSave() {
		return wisdomSave;
	}

	public void setWisdomSave(Integer wisdomSave) {
		this.wisdomSave = wisdomSave;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getCharismaSave() {
		return charismaSave;
	}

	public void setCharismaSave(Integer charismaSave) {
		this.charismaSave = charismaSave;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ac == null) ? 0 : ac.hashCode());
		result = prime * result + ((actions == null) ? 0 : actions.hashCode());
		result = prime * result + ((alignment == null) ? 0 : alignment.hashCode());
		result = prime * result + ((challengeRating == null) ? 0 : challengeRating.hashCode());
		result = prime * result + ((charisma == null) ? 0 : charisma.hashCode());
		result = prime * result + ((charismaSave == null) ? 0 : charismaSave.hashCode());
		result = prime * result + ((conditionImmunities == null) ? 0 : conditionImmunities.hashCode());
		result = prime * result + ((constitution == null) ? 0 : constitution.hashCode());
		result = prime * result + ((dexterity == null) ? 0 : dexterity.hashCode());
		result = prime * result + ((dexteritySave == null) ? 0 : dexteritySave.hashCode());
		result = prime * result + ((hitDice == null) ? 0 : hitDice.hashCode());
		result = prime * result + ((hitPoints == null) ? 0 : hitPoints.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((damageImmunities == null) ? 0 : damageImmunities.hashCode());
		result = prime * result + ((intelligence == null) ? 0 : intelligence.hashCode());
		result = prime * result + ((languages == null) ? 0 : languages.hashCode());
		result = prime * result + ((legendaryActions == null) ? 0 : legendaryActions.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((damageResistances == null) ? 0 : damageResistances.hashCode());
		result = prime * result + ((senses == null) ? 0 : senses.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((specialAbilities == null) ? 0 : specialAbilities.hashCode());
		result = prime * result + ((speed == null) ? 0 : speed.hashCode());
		result = prime * result + ((stealth == null) ? 0 : stealth.hashCode());
		result = prime * result + ((strength == null) ? 0 : strength.hashCode());
		result = prime * result + ((subtype == null) ? 0 : subtype.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((damageVulnerabilities == null) ? 0 : damageVulnerabilities.hashCode());
		result = prime * result + ((wisdom == null) ? 0 : wisdom.hashCode());
		result = prime * result + ((wisdomSave == null) ? 0 : wisdomSave.hashCode());
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
		if (ac == null) {
			if (other.ac != null)
				return false;
		} else if (!ac.equals(other.ac))
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
		if (challengeRating == null) {
			if (other.challengeRating != null)
				return false;
		} else if (!challengeRating.equals(other.challengeRating))
			return false;
		if (charisma == null) {
			if (other.charisma != null)
				return false;
		} else if (!charisma.equals(other.charisma))
			return false;
		if (charismaSave == null) {
			if (other.charismaSave != null)
				return false;
		} else if (!charismaSave.equals(other.charismaSave))
			return false;
		if (conditionImmunities == null) {
			if (other.conditionImmunities != null)
				return false;
		} else if (!conditionImmunities.equals(other.conditionImmunities))
			return false;
		if (constitution == null) {
			if (other.constitution != null)
				return false;
		} else if (!constitution.equals(other.constitution))
			return false;
		if (dexterity == null) {
			if (other.dexterity != null)
				return false;
		} else if (!dexterity.equals(other.dexterity))
			return false;
		if (dexteritySave == null) {
			if (other.dexteritySave != null)
				return false;
		} else if (!dexteritySave.equals(other.dexteritySave))
			return false;
		if (hitDice == null) {
			if (other.hitDice != null)
				return false;
		} else if (!hitDice.equals(other.hitDice))
			return false;
		if (hitPoints == null) {
			if (other.hitPoints != null)
				return false;
		} else if (!hitPoints.equals(other.hitPoints))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (damageImmunities == null) {
			if (other.damageImmunities != null)
				return false;
		} else if (!damageImmunities.equals(other.damageImmunities))
			return false;
		if (intelligence == null) {
			if (other.intelligence != null)
				return false;
		} else if (!intelligence.equals(other.intelligence))
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
		if (damageResistances == null) {
			if (other.damageResistances != null)
				return false;
		} else if (!damageResistances.equals(other.damageResistances))
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
		if (stealth == null) {
			if (other.stealth != null)
				return false;
		} else if (!stealth.equals(other.stealth))
			return false;
		if (strength == null) {
			if (other.strength != null)
				return false;
		} else if (!strength.equals(other.strength))
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
		if (damageVulnerabilities == null) {
			if (other.damageVulnerabilities != null)
				return false;
		} else if (!damageVulnerabilities.equals(other.damageVulnerabilities))
			return false;
		if (wisdom == null) {
			if (other.wisdom != null)
				return false;
		} else if (!wisdom.equals(other.wisdom))
			return false;
		if (wisdomSave == null) {
			if (other.wisdomSave != null)
				return false;
		} else if (!wisdomSave.equals(other.wisdomSave))
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
		builder.append(damageVulnerabilities);
		builder.append(", resistances=");
		builder.append(damageResistances);
		builder.append(", immunnities=");
		builder.append(damageImmunities);
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
		builder.append(", wisdomSave=");
		builder.append(wisdomSave);
		builder.append(", charismaSave=");
		builder.append(charismaSave);
		builder.append("]");
		return builder.toString();
	}


	

	

	
}
