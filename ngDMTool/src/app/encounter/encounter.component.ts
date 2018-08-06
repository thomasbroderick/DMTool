import { Component, OnInit } from '@angular/core';
import { EncounterService } from 'src/app/encounter.service';

@Component({
  selector: 'app-encounter',
  templateUrl: './encounter.component.html',
  styleUrls: ['./encounter.component.css']
})
export class EncounterComponent implements OnInit {

  combat = [];

  loadCombat() {
    this.combat = this.encounterService.index();
  }

  remove(combatant) {
    this.encounterService.remove(combatant);
  }

  constructor(private encounterService: EncounterService) { }
  ngOnInit() {
    this.loadCombat();
  }

}
