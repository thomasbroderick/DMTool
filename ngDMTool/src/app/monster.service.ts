import { AuthenticationService } from './authentication.service';
import { Injectable } from '@angular/core';
import {
  HttpHeaders,
  HttpClient
} from '../../node_modules/@angular/common/http';
import { Monster } from './models/monster';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { environment } from '../environments/environment';
import { Router } from '../../node_modules/@angular/router';

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

  index() {

      const token = this.authService.getToken();
      const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);
      return this.http
        .get<Monster[]>(`${this.url}monster/all`, { headers })
        .pipe(
          catchError((err: any) => {
            console.log(err);
            return throwError('KABOOM');
          })
        );

  }

  create(monster) {
    this.checkLogout();
    const token = this.authService.getToken();
    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);
    return this.http
      .post<Monster>(`${this.url}monster`, monster, { headers })
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('KABOOM');
        })
      );
  }

  update(mid, monster) {
    this.checkLogout();
    const token = this.authService.getToken();
    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);
    return this.http
      .patch<Monster>(`${this.url}monster/${mid}`, monster, { headers })
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
    return this.http.delete<any>(`${this.url}monster/${id}`, { headers }).pipe(
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
    private http: HttpClient,
    private authService: AuthenticationService,
    private router: Router
  ) {}
}
