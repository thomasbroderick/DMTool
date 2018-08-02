import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../models/user';
import { Item } from '../models/item';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  users: User[];
  selectedUser = null;
  newUser = new User();
  editUser  = null;
  items: Item[];
  selectedItem = null;
  newItem = new Item();
  editItem = null;

  createUser() {
    this.userService
      .create(this.newUser)
      .subscribe(data => this.users.push(data), err => console.log(err));

    this.newUser = new User();
    this.loadUser();
  }
  updateUser() {
    this.userService.update(this.editUser, 1).subscribe(
      data => {
        this.loadUser(),
          (this.selectedUser = this.editUser),
          (this.editUser = null);
      },
      err => console.log(err)
    );
  }
  setEditUser() {
    this.editUser = Object.assign({}, this.selectedUser);
  }

  destroyUser(id: number) {
    this.userService
      .destroy(id)
      .subscribe(data => this.loadUser(), err => console.log(err));
  }
  loadUser() {
    this.userService
      .index()
      .subscribe(data => (this.users = data), err => console.log(err));
  }
  createItem() {
    this.itemService
      .create(1, this.newItem)
      .subscribe(data => this.items.push(data), err => console.log(err));

    this.newUser = new User();
    this.loadUser();
  }
  updateItem() {
    this.itemService.update(1, this.editItem.id, this.editItem).subscribe(
      data => {
        this.loadItem(),
          (this.selectedItem = this.editItem),
          (this.editItem = null);
      },
      err => console.log(err)
    );
  }
  setEditItem() {
    this.editItem = Object.assign({}, this.selectedItem);
  }

  destroyItem(id: number) {
    this.userService
      .destroy(id)
      .subscribe(data => this.loadItem(), err => console.log(err));
  }
  loadItem() {
    this.itemService
      .index(1)
      .subscribe(data => (this.items = data), err => console.log(err));
  }
  constructor(private userService: UserService, private itemService: ItemService) {}

  ngOnInit() {
    this.loadUser();
  }

}
