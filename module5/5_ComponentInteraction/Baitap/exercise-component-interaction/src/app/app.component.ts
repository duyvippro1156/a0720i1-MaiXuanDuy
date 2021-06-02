import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'exercise-component-interaction';
  countdownMsg = '';
  countdownAliasMsg = '';
  finishCountdown() {
    this.countdownMsg = 'Finished!';
  }

  endCountdown() {
    this.countdownAliasMsg = 'Ended!';
  }

  onRateChange(value) {
    console.log(value);
  }
}
