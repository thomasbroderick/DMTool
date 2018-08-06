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
    this.refresh();
  }


  remove(combatant) {
    this.combat.slice(this.combat.indexOf(combatant));
    this.refresh();
  }

  index() {
    return this.combat;
  }

  refresh() {
    this.encounter.loadCombat();
  }

  constructor(private encounter: EncounterComponent) {}
}
