import { MainPageComponent } from '../components/main-page/main-page.component';
import { CarListComponent } from '../components/car-list/car-list.component';
import { RentFormComponent } from '../components/rent-form/rent-form.component';
import { RegisterComponent } from '../components/register/register.component';
import { MenuComponent } from '../components/menu/menu.component';
import { LoginComponent } from '../components/login/login.component';
import { NgModule } from "@angular/core";

//eléggé sovány még, -> ha részletezni akarunk dolgokat (pl rendelés feedback, registerform)
@NgModule({
  imports: [
    MainPageComponent,
    CarListComponent,
    RentFormComponent,
    RegisterComponent,
    MenuComponent,
    LoginComponent
  ],
  exports: [
    MainPageComponent,
    CarListComponent,
    RentFormComponent,
    RegisterComponent,
    MenuComponent,
    LoginComponent
  ],
})
export class ComponentItemsModule { }