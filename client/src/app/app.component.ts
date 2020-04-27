import {Component, OnInit} from '@angular/core';
import {AppService} from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';

  constructor(private readonly appService: AppService) {
    console.log(sessionStorage.getItem('boggle'));
  }

  ngOnInit(): void {
  }
}
