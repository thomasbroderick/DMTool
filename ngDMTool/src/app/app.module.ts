import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { GridstackModule } from '@libria/gridstack';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { DiceRollerComponent } from './dice-roller/dice-roller.component';

@NgModule({
  declarations: [
    AppComponent,
    DiceRollerComponent
  ],
  imports: [
    NgbModule.forRoot(),
    BrowserModule,
    GridstackModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
