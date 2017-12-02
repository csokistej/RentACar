import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { CustomerServiceComponent } from './customer-service/customer-service.component';
import { CarServiceComponent } from './car-service/car-service.component';
import { RentServiceComponent } from './rent-service/rent-service.component';


@NgModule({
  declarations: [
    AppComponent,
    CustomerServiceComponent,
    CarServiceComponent,
    RentServiceComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
