import { Rent } from "./Rent";

export class Customer {
    
    rents: Rent[] = [];
    userName: string = '';
    password: string = '';
    fullName: string = '';
    email: string = '';
    address: string = '';
    drivingLicense: string = '';
    accountNumber: string = '';
}