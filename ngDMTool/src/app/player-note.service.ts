import { PlayerNote } from './models/player-note';
import { Npc } from './models/npc';
import { Campaign } from './models/campaign';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '../../node_modules/@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PlayerNoteService {
  private url = environment.baseUrl;
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  index(pid) {
    console.log(`${this.url} player/${pid}/playernote/all/`);
    return this.http.get<PlayerNote[]>(`${this.url}player/${pid}/playernote/all`).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  create(pid, playernote) {
    return this.http.post<Npc>(`${this.url}player/${pid}/playernote`, playernote).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  update(pid, pnid, playernote) {
    console.log(`${this.url}player/${pid}/playernote/${pnid}`);
    return this.http.patch<Npc>(`${this.url}player/${pid}/playernote/${pnid}`, playernote).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  destroy(id) {
    return this.http.delete<any>(`${this.url}/playernote/${id}`, {}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  constructor(private http: HttpClient) { }
}
