import { Component, OnInit } from '@angular/core';
import { Player } from '../models/player';
import { PlayerService } from '../player.service';

@Component({
  selector: 'app-party',
  templateUrl: './party.component.html',
  styleUrls: ['./party.component.css']
})
export class PartyComponent implements OnInit {

  players: Player[] = [];
  newPlayer = new Player();
  editPlayer = null;
  selectedPlayer = null;

  createPlayer() {
    this.playerService
      .create(1, this.newPlayer)
      .subscribe(data => this.players.push(data), err => console.log(err));

  }

  updatePlayer() {
    this.playerService.update(1, this.editPlayer.id, this.editPlayer).subscribe(
      data => {
        this.loadPlayer(),
          (this.selectedPlayer = this.editPlayer),
          (this.editPlayer = null);
      },
      err => console.log(err)
    );
  }
  setEditPlayer() {
    this.editPlayer = Object.assign({}, this.selectedPlayer);
  }

  destroyPlayer(id: number) {
    this.playerService
      .destroy(id)
      .subscribe(data => this.loadPlayer(), err => console.log(err));
  }
  loadPlayer() {
    this.playerService
      .index(1)
      .subscribe(data => (this.players = data), err => console.log(err));
  }

  constructor(private playerService: PlayerService) { }

  ngOnInit() {
  }

}
