import { Component, OnInit } from '@angular/core';
import {
  GridstackComponent,
  GridstackModule
} from '../../node_modules/@libria/gridstack';
import * as _ from '../../node_modules/lodash';
import * as $ from '../../node_modules/jquery';
import { Gridline } from './models/gridline';
import { AuthenticationService } from './authentication.service';
import { Router } from '../../node_modules/@angular/router';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { GridstackService } from '../../node_modules/@libria/gridstack/services/gridstack.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  test = 0;
  title = 'app';
  grids = [];
  theme = 'mountain';
  locked = false;
  constructor(private authenticationService: AuthenticationService,
    private router: Router) {}
  saveGrid() {
    const res = _.map($('.grid-stack .grid-stack-item:visible'), el => {
      el = $(el);
      const index = Number.parseInt(el.attr('index'));
      const gridline = new Gridline();
      gridline.index = index;
      gridline.x = el.attr('data-gs-x');
      gridline.y = el.attr('data-gs-y');
      gridline.width = el.attr('data-gs-width');
      gridline.height = el.attr('data-gs-height');
      this.grids[index] = gridline;
    });
  }
  lock() {
    if (this.locked) {
      const res = _.map($('.grid-stack'), el => {
        el = $(el);
        el.attr('movable', true);
        this.grid.movable(el, true);
      });
      this.locked = false;
    } else {
      const res = _.map($('.grid-stack'), el => {
        el = $(el);
        el.attr('movable', false);
        this.grid.movable(el, false);
      });
      this.locked = true;
    }
  }
  loadGrid() {
    const res = _.map($('.grid-stack .grid-stack-item:visible'), el => {
      el = $(el);
      console.log(this.grids);
      const index = Number.parseInt(el.attr('index'));
      const gridline = this.grids[index];
      console.log(gridline);
      el.attr('data-gs-x', gridline.x);
      el.attr('data-gs-y', gridline.y);
      el.attr('data-gs-width', gridline.width);
      el.attr('data-gs-height', gridline.height);
    });
  }
  tester() {
    console.log(this.grids);
  }

  logout() {
    this.authenticationService.logout();
    if (this.authenticationService.checkLogin()) {
      this.router.navigateByUrl('');
    } else {
      this.router.navigateByUrl('login');
    }
  }

  checkLogin() {
  return this.authenticationService.checkLogin();
  }

  ngOnInit() {
  }
}
