import {Component, OnDestroy, OnInit} from '@angular/core';
import {Boggle} from '../Boggle';

@Component({
  selector: 'app-second-page',
  templateUrl: './second-page.component.html',
  styleUrls: ['./second-page.component.css']
})
export class SecondPageComponent implements OnInit, OnDestroy {

  boggle: Boggle;
  hasTimerStarted = false;
  hasTimerStopped = false;
  tiles = [];
  enteredWord = '';
  validWords: string[] = [];
  validationMsg = '';

  constructor() {
    this.boggle = JSON.parse(sessionStorage.getItem('boggle'));
  }

  ngOnInit() {
    let rowIndex = 0;
    (this.boggle.matrix || []).forEach(m => {
      const newArray = [];
      for (let i = 0; i < m.length; i++) {
        newArray.push(m.charAt(i).toUpperCase());
      }
      this.tiles[rowIndex] = newArray;
      rowIndex++;
    });
    console.log(this.tiles);
    console.log(this.boggle.solutions.length);
  }

  onFinished(): void {
    this.hasTimerStopped = true;
  }

  onTimerClick(): void {
    this.hasTimerStarted = true;
  }

  onSubmit(word: string): void {
    this.validationMsg = '';
    if (!word.length) {
      this.validationMsg = 'Please enter the word.';
      return;
    }
    const found = (this.boggle.solutions || []).find(s => s.toLowerCase() === word.toLowerCase());
    if (found) {
      if (this.validWords.find(v => v.toLowerCase() === found.toLowerCase())) {
        this.validationMsg = 'Please do not enter duplicate word.';
        return;
      }
      this.validWords.push(found);
    } else {
      this.validationMsg = 'Please enter the valid word.';
    }
    this.enteredWord = '';
  }

  ngOnDestroy(): void {
  }
}
