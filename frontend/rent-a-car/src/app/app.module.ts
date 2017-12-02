import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { CustomerServiceComponent } from './customer-service/customer-service.component';
import { CarServiceComponent } from './car-service/car-service.component';


@NgModule({
  declarations: [
    AppComponent,
    CustomerServiceComponent,
    CarServiceComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
