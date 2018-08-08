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
