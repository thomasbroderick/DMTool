import { User } from './user';

export class Monster {
  id: number;
  name: string;
  size: string;
  type: string;
  subtype: string;
  alignment: string;
  vulnerabilities: string;
  resistances: string;
  immunities: string;
  conditionImmunities: string;
  senses: string;
  languages: string;
  specialAbilities: string;
  legendaryActions: string;
  imageUrl: string;
  hitDice: string;
  actions: string;
  stealth: string;
  hitPoints = 0;
  speed: string;
  strength = 0;
  dexterity = 0;
  intelligence = 0;
  wisdom = 0;
  charisma = 0;
  constitution = 0;
  challengeRating = 0;
  dexteritySave = 0;
  constitutionSave = 0;
  wisdomSave = 0;
  charismaSave = 0;
  user: User;

  constructor(
    $id?: number,
    $name?: string,
    $size?: string,
    $type?: string,
    $subtype?: string,
    $alignment?: string,
    $vulnerabilities?: string,
    $resistances?: string,
    $immunities?: string,
    $conditionImmunities?: string,
    $senses?: string,
    $languages?: string,
    $specialAbilities?: string,
    $actions?: string,
    $legendaryActions?: string,
    $imageUrl?: string,
    $hitDice?,
    $stealth?,
    $hitPoints?,
    $speed?: string,
    $strength?,
    $dexterity?,
    $intelligence?,
    $wisdom?,
    $charisma?,
    $constitution?,
    $challengeRating?,
    $dexteritySave?,
    $constitutionSave?,
    $wisdomSave?,
    $charismaSave?,
    $user?: User
  ) {
    this.id = $id;
    this.name = $name;
    this.size = $size;
    this.type = $type;
    this.subtype = $subtype;
    this.alignment = $alignment;
    this.vulnerabilities = $vulnerabilities;
    this.resistances = $resistances;
    this.immunities = $immunities;
    this.conditionImmunities = $conditionImmunities;
    this.senses = $senses;
    this.languages = $languages;
    this.specialAbilities = $specialAbilities;
    this.actions = $actions;
    this.legendaryActions = $legendaryActions;
    this.imageUrl = $imageUrl;
    this.hitDice = $hitDice;
    this.stealth = $stealth;
    this.hitPoints = $hitPoints;
    this.speed = $speed;
    this.strength = $strength;
    this.dexterity = $dexterity;
    this.intelligence = $intelligence;
    this.wisdom = $wisdom;
    this.charisma = $charisma;
    this.constitution = $constitution;
    this.challengeRating = $challengeRating;
    this.dexteritySave = $dexteritySave;
    this.constitutionSave = $constitutionSave;
    this.wisdomSave = $wisdomSave;
    this.charismaSave = $charismaSave;
    this.user = $user;
  }
}
