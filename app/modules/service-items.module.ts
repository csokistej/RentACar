import { RentService } from '../services/rent.service';
import { AuthService } from "../services/auth.service";
import { CarService } from "../services/car.service";
import { NgModule } from "@angular/core";

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