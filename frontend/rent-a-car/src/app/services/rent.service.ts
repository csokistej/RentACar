import { Injectable } from '@angular/core';
import { Rent } from "../models/Rent";
import { HttpClient, HttpHeaders } from "@angular/common/http"; 
import { Observable } from "rxjs"; 


const httpOptions = {
  headers: new HttpHeaders(
    {'Content-Type': 'application/json'}
  )
}

@Injectable()
export class RentService {

    rents: Rent[] = [];
    redirectUrl: string;

    constructor(private http:HttpClient){
    
    }

    getRents() : Observable<Rent[]> {
        return this.http.get<Rent[]>('api/cars');
    }

    getRent(id: number) : Promise<Rent> {
        return this.http.get<Rent>(`api/rents/${id}`).toPromise();
     }

    addRent(rent: Rent) {
    console.log(rent);
    return this.http.post(
      `api/rent/add`,
      rent
    ).toPromise();

  }

    updateIssue(id: number, rent:Rent): Promise<Rent> {
        return this.http.put<Rent>(
            `api/issues/${id}`,
            rent,
            httpOptions
        ).toPromise();
    }


}