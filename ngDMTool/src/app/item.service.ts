import { CampaignNote } from './models/campaign-note';
import { Item } from './models/item';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '../../node_modules/@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ItemService {
  private url = environment.baseUrl;
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  index(uid) {
    console.log(`${this.url} user/${uid}/item/all`);
    return this.http.get<Item[]>(`${this.url}user/${uid}/item/all`).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  create(uid, item) {
    return this.http.post<Item>(`${this.url}user/${uid}/item`, item).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  update(uid, iid, item) {
    console.log(`${this.url}user/${uid}/item/${iid}`);
    return this.http.patch<CampaignNote>(`${this.url}user/${uid}/item/${iid}`, item).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  destroy(id) {
    return this.http.delete<any>(`${this.url}/item/${id}`, {}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  constructor(private http: HttpClient) { }
}
