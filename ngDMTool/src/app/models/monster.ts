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
  actions: string;
  legendaryActions: string;
  imageUrl: string;
  hitDice: number;
  actionsstealth: number;
  hitpoints: number;
  speed: string;
  strenth: number;
  dexterity: number;
  intelligence: number;
  wisdom: number;
  charisma: number;
  constitution: number;
  challengeRating: number;
  dexteritySave: number;
  constitutionSave: number;
  wisdomSave: number;
  charismaSave: number;
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
    $hitDice?: number,
    $actionsstealth?: number,
    $hitpoints?: number,
    $speed?: string,
    $strenth?: number,
    $dexterity?: number,
    $intelligence?: number,
    $wisdom?: number,
    $charisma?: number,
    $constitution?: number,
    $challengeRating?: number,
    $dexteritySave?: number,
    $constitutionSave?: number,
    $wisdomSave?: number,
    $charismaSave?: number,
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
    this.actionsstealth = $actionsstealth;
    this.hitpoints = $hitpoints;
    this.speed = $speed;
    this.strenth = $strenth;
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
