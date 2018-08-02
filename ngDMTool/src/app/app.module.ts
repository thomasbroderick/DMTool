import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { GridstackModule } from '@libria/gridstack';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { DiceRollerComponent } from './dice-roller/dice-roller.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatSliderModule} from '@angular/material/slider';
import {MatSelectModule} from '@angular/material/select';
import { TimerComponent } from './timer/timer.component';
import { BeastiaryComponent } from './beastiary/beastiary.component';
import { HttpClientModule } from '@angular/common/http';
import { AdminComponent } from './admin/admin.component';
import { AppRoutingModule } from './app-routing.module';
import {MatTabsModule} from '@angular/material/tabs';

@NgModule({
  declarations: [
    AppComponent,
    DiceRollerComponent,
    TimerComponent,
    BeastiaryComponent,
    AdminComponent
  ],
  imports: [
    NgbModule.forRoot(),
    BrowserModule,
    GridstackModule.forRoot(),
    AppRoutingModule,
    MatTabsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatSliderModule,
    MatSelectModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
