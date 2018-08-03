import { AuthenticationService } from './authentication.service';
import { CampaignNote } from './models/campaign-note';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '../../node_modules/@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { environment } from '../environments/environment';
import { Router } from '../../node_modules/@angular/router';

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
  this.checkLogout();
   const token = this.authService.getToken();
   const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);

    return this.http.get<CampaignNote[]>(`${this.url}campaign/${cid}/campaignnote/all`, {headers}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  create(cid, campaignnote) {
    this.checkLogout();
   const token = this.authService.getToken();
   const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);
    return this.http.post<CampaignNote>(`${this.url}campaign/${cid}/campaignnote`, campaignnote, {headers}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  update(cid, nid, campaignnote) {
    this.checkLogout();
   const token = this.authService.getToken();
   const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);
    return this.http.patch<CampaignNote>(`${this.url}campaign/${cid}/campaignnote/${nid}`, campaignnote, {headers}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  destroy(id) {
    this.checkLogout();
   const token = this.authService.getToken();
   const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);
    return this.http.delete<any>(`${this.url}campaignnote/${id}`, {headers}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }
  checkLogout() {
    if (!this.authService.checkLogin()) {
      this.router.navigateByUrl('login');
    }
  }

  constructor(private router: Router, private http: HttpClient, private authService: AuthenticationService) { }
}

