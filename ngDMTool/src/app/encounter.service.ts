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
    let count = 0;
    for (let i = 0; i < this.combat.length; i++) {
      if (this.combat[i].name.startsWith(combatant.name)) {
        count++;
      }
    }
    if (count > 0) {
      const combatant2 = Object.assign({}, combatant);
      combatant2.name = combatant2.name + ' ' + count;
      this.combat.push(combatant2);
    } else {
      this.combat.push(combatant);
    }
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
