import { Monster } from './monster';
import { Campaign } from './campaign';

export class Npc {
  id: number;
  name: string;
  description: string;
  imageUrl: string;
  monster: Monster;
  campaign: Campaign;

  constructor(
    $id?: number,
    $name?: string,
    $description?: string,
    $imageUrl?: string,
    $monster?: Monster,
    $campaign?: Campaign
  ) {
    this.id = $id;
    this.name = $name;
    this.description = $description;
    this.imageUrl = $imageUrl;
    this.monster = $monster;
    this.campaign = $campaign;
  }
}
