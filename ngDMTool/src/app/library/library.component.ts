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
  editUser  = null;

  items: Item[];
  itemsVisible = false;
  selectedItem = null;
  newItem = new Item();
  editItem = null;
  constructor(private itemService: ItemService, private userService: UserService) { }

  loadUser() {
    this.userService
      .index()
      .subscribe(data => (this.users = data), err => console.log(err));
  }

  showItems() {
    this.itemsVisible = true;
  }
  createItem() {
    this.itemService
      .create(2, this.newItem)
      .subscribe(data => this.items.push(data), err => console.log(err));

    this.newUser = new User();
    this.loadUser();
  }
  updateItem() {
    this.itemService.update(2, this.editItem.id, this.editItem).subscribe(
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
    this.itemService
      .destroy(id)
      .subscribe(data => this.loadItem(), err => console.log(err));
  }
  loadItem() {
    this.itemService
      .index(1)
      .subscribe(data => (this.items = data), err => console.log(err));
  }

  ngOnInit() {
    this.loadUser();
    this.loadItem();
  }

}
