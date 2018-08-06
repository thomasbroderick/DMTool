import { Component, OnInit } from '@angular/core';
import { ItemService } from '../item.service';
import { Item } from '../models/item';
import { User } from '../models/user';
import { UserService } from '../user.service';

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

  constructor(private userService: UserService) {}

  ngOnInit() {}
}
