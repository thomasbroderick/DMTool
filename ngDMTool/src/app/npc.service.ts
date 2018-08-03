import { Npc } from './models/npc';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '../../node_modules/@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { environment } from '../environments/environment';
import { Router } from '../../node_modules/@angular/router';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class NpcService {
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
  return this.http.get<Npc[]>(`${this.url}campaign/${cid}/npc/all`, {headers}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  create(cid, npc) {
    this.checkLogout();
    const token = this.authService.getToken();
    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);
    return this.http.post<Npc>(`${this.url}campaign/${cid}/npc`, npc, {headers}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  update(cid, nid, npc) {
    this.checkLogout();
    const token = this.authService.getToken();
    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);
    return this.http.patch<Npc>(`${this.url}campaign/${cid}/npc/${nid}`, npc, {headers}).pipe(
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
    return this.http.delete<any>(`${this.url}npc/${id}`, {headers}).pipe(
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

  constructor(private router: Router, private authService: AuthenticationService, private http: HttpClient) { }
}
