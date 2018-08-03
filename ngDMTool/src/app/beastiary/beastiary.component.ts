import { Component, OnInit } from '@angular/core';
import { Monster } from '../models/monster';
import { MonsterService } from '../monster.service';

@Component({
  selector: 'app-beastiary',
  templateUrl: './beastiary.component.html',
  styleUrls: ['./beastiary.component.css']
})
export class BeastiaryComponent implements OnInit {
  monsters: Monster[];

  selected = null;
  newMonster = new Monster();
  editMonster  = null;

  createMonster() {
    this.monsterService
      .create(this.newMonster)
      .subscribe(data => this.monsters.push(data), err => console.log(err));

    this.newMonster = new Monster();
    this.loadMonster();
  }
  update() {
    this.monsterService.update(this.selected.id, this.editMonster).subscribe(
      data => {
        this.loadMonster(),
          (this.selected = this.editMonster),
          (this.editMonster = null);
      },
      err => console.log(err)
    );
  }
  setEdit() {
    this.editMonster = Object.assign({}, this.selected);
  }

  destroyMonster(id: number) {
    this.monsterService
      .destroy(id)
      .subscribe(data => this.loadMonster(), err => console.log(err));
  }
  loadMonster() {
    this.monsterService
      .index()
      .subscribe(data => (this.monsters = data), err => console.log(err));
  }
  constructor(private monsterService: MonsterService) {}

  ngOnInit() {
    this.loadMonster();
  }

}
