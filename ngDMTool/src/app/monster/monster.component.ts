import { PartyComponent } from './../party/party.component';
import { PopoverTriggersComponent } from './../popover-triggers/popover-triggers.component';
import { NgForm } from '@angular/forms';
import { MonsterService } from './../monster.service';
import { Component, OnInit } from '@angular/core';
import { Monster } from '../models/monster';
import { Spell } from '../models/spell';
import { User } from '../models/user';
import { UserService } from '../user.service';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { EncounterService } from '../encounter.service';

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
    private userService: UserService,
    private modalService: NgbModal,
    private encounterService: EncounterService
  ) {}

  closeResult: string;
  selectedSpell = null;

  generateArray(obj) {
    return Object.keys(obj).map(key => {
      return { key: key, value: obj[key] };
    });
  }

  checkLvl(int) {
    const spellArr = [];
    for (let i = 0; i < this.selectedMonster.spells.length; i++) {
      if (this.selectedMonster.spells[i] !== null && this.selectedMonster.spells[i].level === int) {
        spellArr.push(this.selectedMonster.spells[i]);
      }
    }
    return spellArr;
  }

  isObject(obj) {
    return typeof obj === 'object';
  }

  addCombatant(monster: Monster) {
    this.encounterService.add(monster);
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

  open(content) {
    this.modalService
      .open(content, { ariaLabelledBy: 'modal-basic-title', size: 'lg' })
      .result.then(
        result => {
          this.closeResult = `Closed with: ${result}`;
        },
        reason => {
          this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
        }
      );
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }
  ngOnInit() {
    this.loadUser();
    this.loadMonster();
  }
}
