import { Component } from '@angular/core';
import {
  GridstackComponent,
  GridstackModule
} from '../../node_modules/@libria/gridstack';
import * as _ from '../../node_modules/lodash';
import * as $ from '../../node_modules/jquery';
import { Gridline } from './models/gridline';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  test = 0;
  title = 'app';
  grids = [];
  constructor() {}
  saveGrid() {
    const res = _.map($('.grid-stack .grid-stack-item:visible'), (el) => {
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

  loadGrid() {
    const res = _.map($('.grid-stack .grid-stack-item:visible'), (el) => {
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
}
