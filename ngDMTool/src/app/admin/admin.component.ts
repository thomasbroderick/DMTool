import { AuthenticationService } from './../authentication.service';
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
import { PlayerService } from '../player.service';
import { Player } from '../models/player';
import { SpellService } from '../spell.service';
import { Spell } from '../models/spell';
import { TownService } from '../town.service';
import { Town } from '../models/town';
import { CampaignNote } from '../models/campaign-note';
import { CampaignNoteService } from '../campaign-note.service';
import { PlayerNoteService } from '../player-note.service';
import { PlayerNote } from '../models/player-note';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  users: User[] = [];
  selectedUser = null;
  newUser = new User();
  editUser = null;

  items: Item[] = [];
  selectedItem = null;
  newItem = new Item();
  editItem = null;

  campaigns: Campaign[] = [];
  selectedCampaign = null;
  newCampaign = new Campaign();
  editCampaign = null;

  campaignNotes: CampaignNote[] = [];
  selectedCampaignNote = null;
  newCampaignNote = new CampaignNote();
  editCampaignNote = null;

  npcs: Npc[] = [];
  selectedNpc = null;
  newNpc = new Npc();
  editNpc = null;

  players: Player[] = [];
  selectedPlayer = null;
  newPlayer = new Player();
  editPlayer = null;

  spells: Spell[] = [];
  selectedSpell = null;
  newSpell = new Spell();
  editSpell = null;

  towns: Town[] = [];
  selectedTown = null;
  newTown = new Town();
  editTown = null;

  playerNotes: PlayerNote[] = [];
  selectedPlayerNote = null;
  newPlayerNote = new PlayerNote();
  editPlayerNote = null;

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
    if (this.authService.checkLogin()) {
    this.userService
      .index()
      .subscribe(data => (this.users = data), err => console.log(err));
  }
}
  createItem() {
    this.itemService
      .create(this.newItem)
      .subscribe(data => this.items.push(data), err => console.log(err));

    this.newUser = new User();
    this.loadUser();
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
    if (this.authService.checkLogin()) {
    this.itemService
      .index()
      .subscribe(data => (this.items = data), err => console.log(err));
  }
}

  createCampaign() {
    this.campaignService
      .create(this.newCampaign)
      .subscribe(data => this.campaigns.push(data), err => console.log(err));

    this.newUser = new User();
    this.loadUser();
  }
  updateCampaign() {
    this.campaignService
      .update(this.editCampaign.id, this.editCampaign)
      .subscribe(
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
    if (this.authService.checkLogin()) {
    this.campaignService
      .index()
      .subscribe(data => (this.campaigns = data), err => console.log(err));
  }
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
    if (this.authService.checkLogin()) {
    this.npcService.index(1).subscribe(
      data => {
        console.log(data);

        this.npcs = data;
      },
      err => console.log(err)
    );
  }
}

  createPlayer() {
    this.playerService
      .create(1, this.newPlayer)
      .subscribe(data => this.players.push(data), err => console.log(err));

    this.newUser = new User();
    this.loadUser();
  }
  updatePlayer() {
    this.playerService.update(1, this.editPlayer.id, this.editPlayer).subscribe(
      data => {
        this.loadPlayer(),
          (this.selectedPlayer = this.editPlayer),
          (this.editPlayer = null);
      },
      err => console.log(err)
    );
  }
  setEditPlayer() {
    this.editPlayer = Object.assign({}, this.selectedPlayer);
  }

  destroyPlayer(id: number) {
    this.playerService
      .destroy(id)
      .subscribe(data => this.loadPlayer(), err => console.log(err));
  }
  loadPlayer() {
    if (this.authService.checkLogin()) {
    this.playerService
      .index(1)
      .subscribe(data => (this.players = data), err => console.log(err));
  }
}

  createSpell() {
    this.spellService
      .create(this.newSpell)
      .subscribe(data => this.spells.push(data), err => console.log(err));

    this.newUser = new User();
    this.loadUser();
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

  createTown() {
    this.townService
      .create(1, this.newTown)
      .subscribe(data => this.towns.push(data), err => console.log(err));

    this.newUser = new User();
    this.loadUser();
  }
  updateTown() {
    this.townService.update(1, this.editTown.id, this.editTown).subscribe(
      data => {
        this.loadTown(),
          (this.selectedTown = this.editTown),
          (this.editTown = null);
      },
      err => console.log(err)
    );
  }
  setEditTown() {
    this.editTown = Object.assign({}, this.selectedTown);
  }

  destroyTown(id: number) {
    this.townService
      .destroy(id)
      .subscribe(data => this.loadTown(), err => console.log(err));
  }
  loadTown() {
    if (this.authService.checkLogin()) {
    this.townService
      .index(1)
      .subscribe(data => (this.towns = data), err => console.log(err));
  }
}

  createCampaignNote() {
    this.campaignNoteService
      .create(1, this.newCampaignNote)
      .subscribe(
        data => this.campaignNotes.push(data),
        err => console.log(err)
      );

    this.newUser = new User();
    this.loadUser();
  }
  updateCampaignNote() {
    this.campaignNoteService
      .update(1, this.editCampaignNote.id, this.editCampaignNote)
      .subscribe(
        data => {
          this.loadCampaignNote(),
            (this.selectedCampaignNote = this.editCampaignNote),
            (this.editCampaignNote = null);
        },
        err => console.log(err)
      );
  }
  setEditCampaignNote() {
    this.editCampaignNote = Object.assign({}, this.selectedCampaignNote);
  }

  destroyCampaignNote(id: number) {
    this.campaignNoteService
      .destroy(id)
      .subscribe(data => this.loadCampaignNote(), err => console.log(err));
  }
  loadCampaignNote() {
    if (this.authService.checkLogin()) {
      this.campaignNoteService
        .index(1)
        .subscribe(
          data => (this.campaignNotes = data),
          err => console.log(err)
        );
    }
  }

  createPlayerNote() {
    this.playerNoteService
      .create(1, this.newPlayerNote)
      .subscribe(data => this.playerNotes.push(data), err => console.log(err));

    this.newUser = new User();
    this.loadUser();
  }
  updatePlayerNote() {
    this.playerNoteService
      .update(1, this.editPlayerNote.id, this.editPlayerNote)
      .subscribe(
        data => {
          this.loadPlayerNote(),
            (this.selectedPlayerNote = this.editPlayerNote),
            (this.editPlayerNote = null);
        },
        err => console.log(err)
      );
  }
  setEditPlayerNote() {
    this.editPlayerNote = Object.assign({}, this.selectedPlayerNote);
  }

  destroyPlayerNote(id: number) {
    this.playerNoteService
      .destroy(id)
      .subscribe(data => this.loadPlayerNote(), err => console.log(err));
  }
  loadPlayerNote() {
    if (this.authService.checkLogin()) {
      this.playerNoteService
        .index(1)
        .subscribe(data => (this.playerNotes = data), err => console.log(err));
    }
  }
  constructor(
    private playerNoteService: PlayerNoteService,
    private campaignNoteService: CampaignNoteService,
    private townService: TownService,
    private spellService: SpellService,
    private playerService: PlayerService,
    private npcService: NpcService,
    private campaignService: CampaignService,
    private userService: UserService,
    private itemService: ItemService,
    private authService: AuthenticationService
  ) {}

  ngOnInit() {
    this.loadUser();
    this.loadItem();
    this.loadCampaign();
    this.loadNpc();
    this.loadPlayer();
    this.loadSpell();
    this.loadTown();
    this.loadCampaignNote();
    this.loadPlayerNote();
  }
}
