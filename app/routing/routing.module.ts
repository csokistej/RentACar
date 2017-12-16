import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes }   from '@angular/router';
import { CarListComponent } from '../components/car-list/car-list.component';
import { MainPageComponent } from "../components/main-page/main-page.component";
import { LoginComponent } from "../components/login/login.component";
import { RentFormComponent } from '../components/rent-form/rent-form.component';
import { RegisterComponent } from '../components/register/register.component';
import { AuthGuard } from '../auth.guard';
import { CustomerRentsComponent } from '../components/customer-rents/customer-rents.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: '/dashboard',
    pathMatch: 'full'
  },
  {
    path: 'dashboard',
    component: MainPageComponent
  },
  {
    path: 'cars',
    component: CarListComponent,
  //  canActivate: [AuthGuard], //ha ezt kivesszük engedi, tök mind1 hogy guestet beleteszem-e
    data: {roles: ['CUSTOMER', 'ADMIN', 'GUEST']}
  },
  {
      path: 'rent-form',
      component: RentFormComponent,
      canActivate: [AuthGuard],
      data: {roles: ['CUSTOMER', 'ADMIN']}
  },
/*  {
    path: 'cars/:id',
    component: CarListComponent,
    canActivate: [AuthGuard],
    data: {roles: ['USER', 'ADMIN']}
  },*/
  {
      path: 'register',
      component: RegisterComponent, 
   //   data: {roles: ['USER', 'ADMIN', 'GUEST']}

  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'customer-rents',
    component: CustomerRentsComponent,
   // canActivate: [AuthGuard],
    data: {roles: ['GUEST','ADMIN']}
  },
];


@NgModule({
  imports: [ RouterModule.forRoot(routes)  ],
  exports: [ RouterModule ],
  declarations: []
})
export class RoutingModule { }