import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { AuthenticationComponent } from './authentication/authentication.component';

const routes: Routes = [
  { path: 'admin', component: AdminComponent },
  { path: 'login', component: AuthenticationComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
