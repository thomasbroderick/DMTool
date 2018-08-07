import { Component, OnInit, Input } from '@angular/core';
import { ItemService } from '../item.service';
import { Item } from '../models/item';
import { User } from '../models/user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {
  users: User[];
  selectedUser = null;
  newUser = new User();
  editUser  = null;
  createNew = false;

  items: Item[];
  itemsVisible = true;
  selectedItem = null;
  newItem = new Item();
  editItem = null;

  constructor(private itemService: ItemService, private userService: UserService) { }

  loadUser() {
    this.userService
      .index()
      .subscribe(data => (this.users = data), err => console.log(err));
  }

  showCreateDiv() {
    this.createNew = true;
    this.itemsVisible = false;
  }

  createItem() {
    this.itemService
      .create(this.newItem)
      .subscribe(data => this.items.push(data), err => console.log(err));

    this.newUser = new User();
    this.loadUser();
    this.createNew = false;
    this.itemsVisible = true;
  }
  updateItem() {
    this.itemService.update(this.editItem.id, this.editItem).subscribe(
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
      .index()
      .subscribe(data => (this.items = data), err => console.log(err));
  }
  ngOnInit() {
    this.loadUser();
    this.loadItem();
  }

}
