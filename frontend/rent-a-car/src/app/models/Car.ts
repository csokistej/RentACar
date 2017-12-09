import { Rent } from "./Rent";

export class Car {

    id: number = 0;
    rents: Rent[] = [];
    carType: string = '';
    age: number = 0;
    distance: number = 0;
    pricePerHour: number = 0;
    available: boolean = true;
    
}