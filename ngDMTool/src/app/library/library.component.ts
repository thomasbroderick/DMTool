import { MonsterService } from './../monster.service';
import { NameFilterPipe } from './../name-filter.pipe';
import { Component, OnInit } from '@angular/core';
import { ItemService } from '../item.service';
import { Item } from '../models/item';
import { User } from '../models/user';
import { UserService } from '../user.service';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';
import { SpellService } from '../spell.service';
import { Monster } from '../models/monster';
import { Spell } from '../models/spell';

@Component({
  selector: 'app-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.css']
})
export class LibraryComponent implements OnInit {
  users: User[];
  selectedUser = null;
  newUser = new User();
  editUser = null;
  createNew = false;
  itemsVisible = false;
  monstersVisible = false;
  spellsVisible = false;
  searchText = new FormControl('');
  options: string[] = [];
  items: Item[];
  monsters: Monster[];
  spells: Spell[];
  filteredOptions: Observable<string[]>;

  loadItem() {
    this.itemService.index().subscribe(
      data => {
        this.items = data;
      },
      err => console.log(err)
    );
    this.options.push(this.nameFilter.transform(this.items));
  }
  loadMonster() {
    this.monsterService.index().subscribe(
      data => {
        this.monsters = data;
      },
      err => console.log(err)
    );
    this.options.push(this.nameFilter.transform(this.monsters));
  }
  loadSpell() {
    this.spellService.index().subscribe(
      data => {
        this.spells = data;
      },
      err => console.log(err)
    );
    this.options.push(this.nameFilter.transform(this.spells));
  }

  viewItems() {
    this.itemsVisible = true;
    this.monstersVisible = false;
    this.spellsVisible = false;
  }
  viewMonsters() {
    this.itemsVisible = false;
    this.monstersVisible = true;
    this.spellsVisible = false;
  }
  viewSpells() {
    this.itemsVisible = false;
    this.monstersVisible = false;
    this.spellsVisible = true;
  }

  constructor(
    private userService: UserService,
    private nameFilter: NameFilterPipe,
    private monsterService: MonsterService,
    private itemService: ItemService,
    private spellService: SpellService
  ) {}

  ngOnInit() {
    this.loadItem();
    this.loadMonster();
    this.loadSpell();
    this.filteredOptions = this.searchText.valueChanges.pipe(
      startWith(''),
      map(value => this._filter(value))
    );

    console.log(this.options);
  }
  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.options.filter(option =>
      option.toLowerCase().includes(filterValue)
    );
  }
}
