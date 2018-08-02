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
export class CampaignService {
  private url = environment.baseUrl;
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  index(uid) {
    console.log(`${this.url}user/${uid}/campaign/all`);
    return this.http.get<Campaign[]>(`${this.url}user/${uid}/campaign/all`).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  create(uid, campaign) {
    return this.http.post<Campaign>(`${this.url}user/${uid}campaign/`, campaign).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  update(uid, cid, campaign) {
    console.log(`${this.url}user/${uid}/campaign/${cid}`);
    return this.http.patch<Campaign>(`${this.url}user/${uid}/campaign/${cid}`, campaign).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  destroy(id) {
    return this.http.delete<any>(`${this.url}/campaign/${id}`, {}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  constructor(private http: HttpClient) { }
}
