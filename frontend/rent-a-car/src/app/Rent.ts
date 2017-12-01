import { Customer } from "./Customer";
import { Car } from "./Car";

export class Rent {
    customer: Customer;
    car: Car;
    rentalStatus: string = '';
    startDate: string = '';
    endDate: string = '';
    price: number = 0;
}