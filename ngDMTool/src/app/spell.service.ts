import { Spell } from './models/spell';
import { CampaignNote } from './models/campaign-note';
import { Campaign } from './models/campaign';
import { Injectable } from '@angular/core';
import {
  HttpHeaders,
  HttpClient
} from '../../node_modules/@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { environment } from '../environments/environment';
import { Router } from '../../node_modules/@angular/router';
import { AuthenticationService } from './authentication.service';

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

  index() {
      const token = this.authService.getToken();
      const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);
      return this.http.get<Spell[]>(`${this.url}spell/all`, { headers }).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('KABOOM');
        })
      );

  }

  create(spell) {
    this.checkLogout();
    const token = this.authService.getToken();
    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);
    return this.http.post<Spell>(`${this.url}spell`, spell, { headers }).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  update(sid, spell) {
    this.checkLogout();
    const token = this.authService.getToken();
    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);
    return this.http
      .patch<Spell>(`${this.url}spell/${sid}`, spell, { headers })
      .pipe(
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
    return this.http.delete<any>(`${this.url}spell/${id}`, { headers }).pipe(
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
  checkLogin() {
    if (localStorage.getItem('token')) {
      return true;
    }
    return false;
  }

  constructor(
    private router: Router,
    private authService: AuthenticationService,
    private http: HttpClient
  ) {}
}
