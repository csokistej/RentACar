import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { Car } from '../../models/Car';
import { CarService} from '../../services/car.service';
import { AuthService } from '../../services/auth.service';
import { RentService } from '../../services/rent.service';
import { Rent } from '../../models/Rent';



@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {

   cars: Car[] = [];
   selectedCar: Car = new Car();
   selectedId: number = 0;
   filteredCars: Car[];
   rent: Rent = new Rent();

   message: string = '';

   constructor(
    private carService: CarService, 
    private authService: AuthService,
    private rentService: RentService,
    private router:Router
  ) { }

  ngOnInit() {
    this.carService.getCars().subscribe(cars => {
      this.cars = cars;
   // this.filterCars();
    });
  }

  onCreateRent(carId: number){
    this.selectedId = carId

    this.selectedCar = this.cars[ carId - 1 ]
  }

  onCancelRent(){
    this.selectedId = 0
  }

  async submit(form) {
    if (form.invalid) {
      return;
    }
    try {
      this.rent.car = this.selectedCar;
      this.rent.customer = this.authService.customer;
      this.message = 'Try to register';
      console.log(this.rent)
      await this.rentService.addRent(this.rent);
      console.log('success')
      this.router.navigate([this.rentService.redirectUrl]);
    }
    catch(e) {
      this.message = 'Rent failed';
      console.log(e);
    }
  }

//nah hogy mi alapján kéne leszürni az nincs meg *<|:-( santa is sad*/

}
