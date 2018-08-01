import { Player } from './player';

export class PlayerNote {
  id: number;
  text: string;
  player: Player;

  constructor($id?: number, $text?: string, $player?: Player) {
    this.id = $id;
    this.text = $text;
    this.player = $player;
  }
}
