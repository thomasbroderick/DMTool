import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '../../../node_modules/@angular/router';
import { AuthenticationService } from '../authentication.service';
import { User } from '../models/user';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.css']
})
export class AuthenticationComponent implements OnInit {
  login(form: NgForm) {
  this.authenticationService.login(form.value.username, form.value.password).subscribe(
    data => {
      this.router.navigateByUrl(''), console.log('working');
    },
    err => console.log(err)
  );
}

logout() {
  this.authenticationService.logout();
  if (this.authenticationService.checkLogin()) {
    this.router.navigateByUrl('');
  } else {
    this.router.navigateByUrl('login');
  }
}

checkLogin() {
return this.authenticationService.checkLogin();
}
register(form: NgForm) {
  this.authenticationService
    .register(
      new User(form.value.username, form.value.password, true, 'standard')
    )
    .subscribe(
      data => {
        console.log('working');
        this.authenticationService
          .login(form.value.email, form.value.password)
          .subscribe(
            data => {
              this.router.navigateByUrl('');
            },
            err => console.log(err)
          );
      },
      err => console.log(err)
    );
}

  constructor(private authenticationService: AuthenticationService,
    private router: Router) {}

  ngOnInit() {
  }

}
