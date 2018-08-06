import { Injectable } from '@angular/core';
import { Monster } from './models/monster';
import { Player } from './models/player';
import { Npc } from './models/npc';
import { EncounterComponent } from './encounter/encounter.component';

@Injectable({
  providedIn: 'root'
})
export class EncounterService {
  combat = [];

  add(combatant) {
    this.combat.push(combatant);
    console.log(combatant);
  }


  remove(combatant) {
    this.combat.splice(this.combat.indexOf(combatant), 1);
  }

  reset() {
    this.combat = [];
  }
  index() {
    return this.combat;
  }


  constructor() {}
}
