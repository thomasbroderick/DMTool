import { Spell } from './models/spell';
import { CampaignNote } from './models/campaign-note';
import { Campaign } from './models/campaign';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '../../node_modules/@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SpellService {
  private url = environment.baseUrl;
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  index(uid) {
    console.log(`${this.url}user/${uid}/spell/all`);
    return this.http.get<Spell[]>(`${this.url}user/${uid}/spell/all`).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  create(uid, spell) {
    return this.http.post<Spell>(`${this.url}user/${uid}spell`, spell).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  update(uid, sid, spell) {
    console.log(`${this.url}user/${uid}/spell/${sid}`);
    return this.http.patch<Spell>(`${this.url}user/${uid}/spell/${sid}`, spell).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  destroy(id) {
    return this.http.delete<any>(`${this.url}/spell/${id}`, {}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  constructor(private http: HttpClient) { }
}
