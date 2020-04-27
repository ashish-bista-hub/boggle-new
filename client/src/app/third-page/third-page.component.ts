import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-third-page',
  templateUrl: './third-page.component.html',
  styleUrls: ['./third-page.component.css']
})
export class ThirdPageComponent implements OnInit {
  validWords: string[] = [];
  points = [];
  total = 0;

  constructor(private readonly route: ActivatedRoute) {
  }

  ngOnInit() {
    this.validWords = this.route.snapshot.params['validWords'].split(',') || [];
    console.log(this.validWords);
    this.validWords.forEach(w => {
      const point = this.getPoint(w);
      this.points.push({word: w, point: point});
      this.total += point;
    });
  }

  private getPoint(word: string): number {
    if (!word.length) {
      return 0;
    }
    switch (word.length) {
      case 3:
        return 1;
      case 4:
        return 2;
      case 5:
        return 3;
      default:
        return 5;
    }
  }
}
