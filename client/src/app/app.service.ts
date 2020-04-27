import {Injectable} from '@angular/core';
import {BehaviorSubject} from 'rxjs';
import {Boggle} from './Boggle';
import {HttpClient} from '@angular/common/http';

@Injectable({providedIn: 'root'})
export class AppService {

  private boggle: Boggle;

  constructor(private http: HttpClient) {
    this.http.get<Boggle>('http://localhost:7080/api/v1/boggle').subscribe(data => {
      this.boggle = data;
      console.log(data);
      sessionStorage.setItem('boggle', JSON.stringify(this.boggle));
    });
  }
}
