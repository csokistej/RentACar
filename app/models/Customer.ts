import { Rent } from "./Rent";

export class Customer {
    
    id: number = 0;
    rents: Rent[] = [];
    userName: string = '';
    password: string = '';
    fullName: string = '';
    email: string = '';
    address: string = '';
    drivingLicense: string = '';
    accountNumber: string = '';
    role: string = 'GUEST';
}