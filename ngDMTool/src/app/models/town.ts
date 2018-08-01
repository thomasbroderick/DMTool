import { Campaign } from './campaign';
import { TownNote } from './town-note';

export class Town {
  id: number;
  name: string;
  description: string;
  campaign: Campaign;
  townNotes: TownNote;

  constructor(
    $id?: number,
    $name?: string,
    $description?: string,
    $campaign?: Campaign,
    $townNotes?: TownNote
  ) {
    this.id = $id;
    this.name = $name;
    this.description = $description;
    this.campaign = $campaign;
    this.townNotes = $townNotes;
  }
}
