import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { RentService } from '../../services/rent.service';
import { Customer } from '../../models/Customer';
import { Router } from "@angular/router";
import { Car } from '../../models/Car';
import { CarService} from '../../services/car.service';
import { Rent } from '../../models/Rent';


@Component({
  selector: 'app-customer-rents',
  templateUrl: './customer-rents.component.html',
  styleUrls: ['./customer-rents.component.css']
})
export class CustomerRentsComponent implements OnInit {

  customer: Customer = new Customer();
  message: string = '';
  rents: Rent[] = [];


  constructor(private authService: AuthService, private rentService:  RentService, private router: Router ) { }

  ngOnInit() {
    this.customer = this.authService.customer;
    this.rentService.getRentsByCustomer().subscribe(rents => {
      console.log(rents);
      this.rents = rents;
    });
  }

}
