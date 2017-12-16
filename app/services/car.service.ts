import { Injectable } from '@angular/core';
import { Car } from "../models/Car";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from "rxjs"; 

const httpOptions = {
  headers: new HttpHeaders(
    {'Content-Type': 'application/json'}
  )
}

@Injectable()
export class CarService {

    cars: Car[] = [

    ];

    constructor(private http: HttpClient ){

    }

    getCars() : Observable<Car[]> {
        return this.http.get<Car[]>('api/car/all');
    }

    getCar(id: number) : Promise<Car> {
        return this.http.get<Car>(`api/car/${id}`).toPromise();
     }

    addCar(car: Car) {
        console.log(car);
        return this.http.post(
        `api/cars`,
        car
        ).toPromise();
    }

    updateCar(id: number, issue:Car): Promise<Car> {
        return this.http.put<Car>(
        `api/car/${id}`,
        issue,
        httpOptions
        ).toPromise();
    }
    deleteCar(id: number, car:Car): Promise<Car> {
        return this.http.delete<Car>(`/api/car/delete/${id}`).toPromise();
    }
}