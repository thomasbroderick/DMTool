import { Town } from './models/town';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '../../node_modules/@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TownService {
  private url = environment.baseUrl;
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  index(cid) {
    console.log(`${this.url} campaign/${cid}/town/all/`);
    return this.http.get<Town[]>(`${this.url}campaign/${cid}/town/all`).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  create(cid, town) {
    return this.http.post<Town>(`${this.url}campaign/${cid}/town`, town).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  update(cid, tid, town) {
    console.log(`${this.url}campaign/${cid}/town/${tid}`);
    return this.http.patch<Town>(`${this.url}campaign/${cid}/town/${tid}`, town).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  destroy(id) {
    return this.http.delete<any>(`${this.url}town/${id}`, {}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  constructor(private http: HttpClient) { }
}
