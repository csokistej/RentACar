import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from "@angular/common/http";
import { FlexLayoutModule } from '@angular/flex-layout';

import { MaterialItemsModule } from "./modules/material-items.module";
import { AppComponent } from './components/app/app.component';
import { MainPageComponent } from './components/main-page/main-page.component';
import { CarListComponent } from './components/car-list/car-list.component';
import { RentFormComponent } from './components/rent-form/rent-form.component';
import { MenuComponent } from './components/menu/menu.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { CarService } from './services/car.service';
import { RentService } from './services/rent.service';
import { AuthService } from './services/auth.service';
import { RoutingModule } from './routing/routing.module'; 
import { AuthGuard } from './auth.guard';
import { CustomerRentsComponent } from './components/customer-rents/customer-rents.component';

@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    CarListComponent,
    RentFormComponent,
    RegisterComponent,
    MenuComponent,
    LoginComponent,
    CustomerRentsComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    RoutingModule,
    FormsModule,
    HttpClientModule,
    MaterialItemsModule
  ],
  providers: [ CarService, RentService, AuthService, AuthGuard ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
