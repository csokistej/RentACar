
import { Customer } from './Customer';
import { Car } from './Car';

export class Rent {
    id: number = 0;
    customer: Customer;
    car: Car;
    rentalStatus: string = '';
    startDate: string = '';
    endDate: string = '';
    price: number = 0;
}