import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.scss']
})
export class CalculatorComponent implements OnInit {

  number1 = 0;
  number2 = 0;
  calculator = '';
  result = 0;
  constructor() { }

  ngOnInit(): void {
  }

  calculateResult() {
    switch (this.calculator) {
      case '+': {
        this.result = this.number1 + this.number2;
        break;
      }
      case  '-': {
        this.result = this.number1 - this.number2;
        break;
      }
      case  '*': {
        this.result = this.number1 * this.number2;
        break;
      }
      case  '/': {
        this.result = this.number1 / this.number2;
        break;
      }


    }
  }
}
