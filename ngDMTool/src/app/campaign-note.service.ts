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
export class CampaignNoteService {
  private url = environment.baseUrl;
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  index(cid) {
    console.log(`${this.url} + campaignnote/all/${cid}`);
    return this.http.get<CampaignNote[]>(`${this.url} + campaignnote/all/${cid}`).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  create(cid, campaignnote) {
    return this.http.post<Campaign>(`${this.url}campaignnote/campaign/${cid}/`, campaignnote).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  update(cid, nid, campaignnote) {
    console.log(`${this.url}campaign/${cid}/campaignnote/${nid}`);
    return this.http.patch<CampaignNote>(`${this.url}campaign/${cid}/campaignnote/${nid}`, campaignnote).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  destroy(id) {
    return this.http.delete<any>(`${this.url}/campaignnote/${id}`, {}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  constructor(private http: HttpClient) { }
}
