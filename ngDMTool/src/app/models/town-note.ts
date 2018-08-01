import { Town } from './town';

export class TownNote {
  id: number;
  content: string;
  town: Town;

  constructor($id?: number, $content?: string, $town?: Town) {
    this.id = $id;
    this.content = $content;
    this.town = $town;
  }
}
