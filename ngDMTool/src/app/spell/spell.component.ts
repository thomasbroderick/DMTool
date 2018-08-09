import { AuthenticationService } from './../authentication.service';
import { AuthenticationComponent } from './../authentication/authentication.component';
import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { Spell } from '../models/spell';
import { SpellService } from '../spell.service';
import { UserService } from '../user.service';
import { NgForm } from '../../../node_modules/@angular/forms';

@Component({
  selector: 'app-spell',
  templateUrl: './spell.component.html',
  styleUrls: ['./spell.component.css']
})
export class SpellComponent implements OnInit {
  users: User[] = [];
  selectedUser = null;
  newUser = new User();
  editUser = null;
  spells: Spell[] = [];
  newSpell = new Spell();

  selectedSpell = null;
  editSpell = null;
  spellsVisible = true;
  createNew = false;
  spellAttributes = [
    'name',
    'description',
    'higherLevel',
    'range',
    'components',
    'material',
    'ritual',
    'duration',
    'concentration',
    'castingTime',
    'level',
    'school',
    'classes'
  ];

  generateArray(obj) {
    return Object.keys(obj).map(key => {
      return { key: key, value: obj[key] };
    });
  }

  constructor(
    private spellService: SpellService,
    private userService: UserService,
    private authService: AuthenticationService
  ) {}

  isObject(obj) {
    return typeof obj === 'object';
  }

  loadUser() {
    if (this.authService.checkLogin()) {
      this.userService
        .index()
        .subscribe(data => (this.users = data), err => console.log(err));
    }
  }
  showCreateDiv() {
    this.createNew = true;
    this.spellsVisible = false;
  }

  createSpell(form: NgForm) {
    const newSpell: Spell = form.value;

    this.spellService
      .create(newSpell)
      .subscribe(data => this.spells.push(data), err => console.log(err));

    this.newUser = new User();
    this.loadUser();
    this.createNew = false;
    this.spellsVisible = true;
  }
  updateSpell() {
    this.spellService.update(this.editSpell.id, this.editSpell).subscribe(
      data => {
        this.loadSpell(),
          (this.selectedSpell = this.editSpell),
          (this.editSpell = null);
      },
      err => console.log(err)
    );
  }
  setEditSpell() {
    this.editSpell = Object.assign({}, this.selectedSpell);
  }

  destroySpell(id: number) {
    this.spellService
      .destroy(id)
      .subscribe(data => this.loadSpell(), err => console.log(err));
  }
  loadSpell() {
    if (this.authService.checkLogin()) {
    this.spellService
      .index()
      .subscribe(data => (this.spells = data), err => console.log(err));
  }
}
  ngOnInit() {
    this.loadUser();
    this.loadSpell();
  }
}
