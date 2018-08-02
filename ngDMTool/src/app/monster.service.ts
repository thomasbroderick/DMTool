import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '../../node_modules/@angular/common/http';
import { Monster } from './models/monster';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MonsterService {
  private url = environment.baseUrl;
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  index(uid) {
    console.log(`${this.url}user/${uid}/monster/all`);
    return this.http.get<Monster[]>(`${this.url}user/${uid}/monster/all`).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  create(uid, monster) {
    return this.http.post<Monster>(`${this.url}user/${uid}/monster`, monster).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  update(uid, mid, monster) {
    console.log(`${this.url}user/${uid}/monster/${mid}`);
    return this.http.patch<Monster>(`${this.url}user/${uid}/monster/${mid}`, monster).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  destroy(id) {
    return this.http.delete<any>(`${this.url}monster/${id}`, {}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  constructor(private http: HttpClient) { }
}
