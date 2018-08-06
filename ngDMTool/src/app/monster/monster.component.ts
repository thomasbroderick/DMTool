import { NgForm } from '@angular/forms';
import { MonsterService } from './../monster.service';
import { Component, OnInit } from '@angular/core';
import { Monster } from '../models/monster';
import { User } from '../models/user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-monster',
  templateUrl: './monster.component.html',
  styleUrls: ['./monster.component.css']
})
export class MonsterComponent implements OnInit {
  users: User[] = [];
  selectedUser = null;
  newUser = new User();
  editUser = null;
  monsters: Monster[] = [];
  selectedMonster = null;

  editMonster = null;
  monstersVisible = true;
  createNew = false;
  monsterAttributesString: string[] = [
    'name',
    'size',
    'type',
    'subtype',
    'alignment',
    'vulnerabilities',
    'resistances',
    'immunities',
    'conditionImmunities',
    'senses',
    'languages',
    'specialAbilities',
    'actions',
    'legendaryActions',
    'imageUrl',
    'hitDice',
    'actions',
    'stealth',
    'speed'
  ];

  monsterAttributesInt = [
    'hitPoints',
    'strength',
    'dexterity',
    'intelligence',
    'wisdom',
    'charisma',
    'constitution',
    'challengeRating',
    'dexteritySave',
    'constitutionSave',
    'wisdomSave',
    'charismaSave'
  ];

  constructor(
    private monsterService: MonsterService,
    private userService: UserService
  ) {}

  generateArray(obj) {
    return Object.keys(obj).map(key => {
      return { key: key, value: obj[key] };
    });
  }

  isObject(obj) {
    return typeof obj === 'object';
  }

  loadUser() {
    this.userService
      .index()
      .subscribe(data => (this.users = data), err => console.log(err));
  }
  showCreateDiv() {
    this.createNew = true;
    this.monstersVisible = false;
  }

  createMonster(form: NgForm) {
    const newMonster: Monster = form.value;

    this.monsterService
      .create(newMonster)
      .subscribe(data => this.monsters.push(data), err => console.log(err));

    this.newUser = new User();
    this.loadUser();
    this.createNew = false;
    this.monstersVisible = true;
  }
  updateMonster() {
    this.monsterService.update(this.editMonster.id, this.editMonster).subscribe(
      data => {
        this.loadMonster(),
          (this.selectedMonster = this.editMonster),
          (this.editMonster = null);
      },
      err => console.log(err)
    );
  }
  setEditMonster() {
    this.editMonster = Object.assign({}, this.selectedMonster);
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
  ngOnInit() {
    this.loadUser();
    this.loadMonster();
  }
}
