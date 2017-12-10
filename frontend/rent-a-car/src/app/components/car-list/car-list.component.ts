import { Component, OnInit } from '@angular/core';
import { Car } from '../../models/Car';
import { CarService } from '../../services/car.service';



@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {

   cars: Car[] = [];
   //selectedCar: Car;
   selectedId: number = 0;
   filteredCars: Car[] = [];

   constructor(
    private carService: CarService,
  ) { }

  ngOnInit() {
    this.carService.getCars().subscribe(cars => {
      this.cars = cars;
   // this.filterCars();
    });
  }

//nah hogy mi alapján kéne leszürni az nincs meg *<|:-( santa is sad
  /*filterIssues() {
    this.filteredCars = this.filteredCars === ''
      ? this.cars
      : this.cars.filter(
          car => car.available === 'T'
        )
  }*/

}
