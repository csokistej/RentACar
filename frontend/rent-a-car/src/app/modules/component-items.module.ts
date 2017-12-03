import { MainPageComponent } from '../components/main-page/main-page.component';

import { MenuComponent } from '../components/menu/menu.component';
import { LoginComponent } from '../components/login/login.component';
import { NgModule } from "@angular/core";

@NgModule({
  imports: [
    MainPageComponent,
    
    MenuComponent,
    LoginComponent
  ],
  exports: [
    MainPageComponent,

    MenuComponent,
    LoginComponent
  ],
})
export class ComponentItemsModule { }