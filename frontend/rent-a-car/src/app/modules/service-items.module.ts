import { RentService } from '../services/rent.service';
import { AuthService } from "../services/auth.service";
import { CarService } from "../services/car.service";
import { NgModule } from "@angular/core";

//A materialokhoz : npm install --save @angular/material @angular/animations @angular/cdk
//https://alligator.io/angular/angular-material-2/
@NgModule({
  imports: [
    RentService,
    CarService,
    AuthService,
  ],
  exports: [
    RentService,
    CarService,
    AuthService,
  ],
})
export class ServiceItemsModule { }