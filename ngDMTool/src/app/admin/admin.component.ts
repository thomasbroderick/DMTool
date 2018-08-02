import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../models/user';
import { Item } from '../models/item';
import { ItemService } from '../item.service';
import { CampaignService } from '../campaign.service';
import { Campaign } from '../models/campaign';
import { Npc } from '../models/npc';
import { NpcService } from '../npc.service';
import { Logs } from '../../../node_modules/@types/selenium-webdriver';

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

  campaigns: Campaign[];
  selectedCampaign = null;
  newCampaign = new Campaign();
  editCampaign = null;

  npcs: Npc[] = [];
  selectedNpc = null;
  newNpc = new Npc();
  editNpc = null;

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
      .index(2)
      .subscribe(data => (this.items = data), err => console.log(err));
  }

  createCampaign() {
    this.campaignService
      .create(2, this.newCampaign)
      .subscribe(data => this.campaigns.push(data), err => console.log(err));

    this.newUser = new User();
    this.loadUser();
  }
  updateCampaign() {
    this.campaignService.update(2, this.editCampaign.id, this.editCampaign).subscribe(
      data => {
        this.loadCampaign(),
          (this.selectedCampaign = this.editCampaign),
          (this.editCampaign = null);
      },
      err => console.log(err)
    );
  }
  setEditCampaign() {
    this.editCampaign = Object.assign({}, this.selectedCampaign);
  }

  destroyCampaign(id: number) {
    this.campaignService
      .destroy(id)
      .subscribe(data => this.loadCampaign(), err => console.log(err));
  }
  loadCampaign() {
    this.campaignService
      .index(2)
      .subscribe(data => (this.campaigns = data), err => console.log(err));
  }

  createNpc() {
    this.npcService
      .create(1, this.newNpc)
      .subscribe(data => this.npcs.push(data), err => console.log(err));

    this.newUser = new User();
    this.loadUser();
  }
  updateNpc() {
    this.npcService.update(1, this.editNpc.id, this.editNpc).subscribe(
      data => {
        this.loadNpc(),
          (this.selectedNpc = this.editNpc),
          (this.editNpc = null);
      },
      err => console.log(err)
    );
  }
  setEditNpc() {
    this.editNpc = Object.assign({}, this.selectedNpc);
  }

  destroyNpc(id: number) {
    this.npcService
      .destroy(id)
      .subscribe(data => this.loadNpc(), err => console.log(err));
  }
  loadNpc() {
    console.log('sldfjdslkjf');
    this.npcService
      .index(1)
      .subscribe(data => {
        console.log("**********************");

          console.log(data);

          this.npcs = data;
        },
        err => console.log(err)
      );
  }

  constructor(private npcService: NpcService, private campaignService: CampaignService,
    private userService: UserService, private itemService: ItemService) {}

  ngOnInit() {
    this.loadUser();
    this.loadItem();
    this.loadCampaign();
    this.loadNpc();
  }

}
