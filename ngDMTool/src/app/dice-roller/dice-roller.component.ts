import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

export interface Num {
  value: number;
  viewValue: string;
}

@Component({
  selector: 'app-dice-roller',
  templateUrl: './dice-roller.component.html',
  styleUrls: ['./dice-roller.component.css']
})
export class DiceRollerComponent implements OnInit {
  dieType = null;
  dieQuant = null;
  dieResult = null;
  public radioGroupForm: FormGroup;
  nums: Num[] = [
    { value: 1, viewValue: '1' },
    { value: 2, viewValue: '2' },
    { value: 3, viewValue: '3' },
    { value: 4, viewValue: '4' },
    { value: 5, viewValue: '5' },
    { value: 6, viewValue: '6' },
    { value: 7, viewValue: '7' },
    { value: 8, viewValue: '8' },
    { value: 9, viewValue: '9' },
    { value: 10, viewValue: '10' }
  ];

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit() {
    this.radioGroupForm = this.formBuilder.group({
      model: 1
    });
  }

  roll() {
    if (this.dieType) {
      if (this.dieQuant === 1 || this.dieQuant === null) {
        this.dieResult = Math.ceil(Math.random() * this.dieType);
      } else {
        let result = '';
        let total = 0;
        for (let i = 0; i < this.dieQuant; i++) {
          const roll = Math.ceil(Math.random() * this.dieType);
          if (i !== this.dieQuant - 1) {
            result += roll + ' + ';
            total += roll;
          } else {
            total += roll;
            result += roll + ' = ' + total;
          }
        }
        this.dieResult = result;
      }
    } else {
      this.dieResult = 'Please select a die type';
    }
  }
}
