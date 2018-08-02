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

  index(cid) {
    console.log(`${this.url} player/${cid}/npc/all/`);
    return this.http.get<Npc[]>(`${this.url}campaign/${cid}/campaignnote/all`).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  create(cid, npc) {
    return this.http.post<Npc>(`${this.url}campaign/${cid}/npc`, npc).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  update(cid, nid, npc) {
    console.log(`${this.url}campaign/${cid}/npc/${nid}`);
    return this.http.patch<Npc>(`${this.url}campaign/${cid}/npc/${nid}`, npc).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  destroy(id) {
    return this.http.delete<any>(`${this.url}/npc/${id}`, {}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  constructor(private http: HttpClient) { }
}
