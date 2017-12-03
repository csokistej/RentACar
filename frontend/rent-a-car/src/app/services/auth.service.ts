import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Customer } from "../models/Customer";
import { tap } from "rxjs/operators";

const httpOptions = {
  headers: new HttpHeaders(
    {'Content-Type': 'application/json'}
  )
}

@Injectable()
export class AuthService {

  isLoggedIn: boolean = false;
  redirectUrl: string;
  customer: Customer;

  constructor(
    private http: HttpClient
  ) { }

  login(customer: Customer) {
    return this.http.post<Customer>(
        // 'http://localhost:4200/api/customer/login',
        'api/customer/login',
        customer,
        httpOptions
      )
      .pipe(
        tap((customer: Customer) => {
          this.isLoggedIn = true;
          this.customer = customer;
        })
      )
      .toPromise();
  }

  logout() {
    // https://stackoverflow.com/a/46816238
    return this.http.post(
        'api/customer/logout',
        {},
        httpOptions
      )
      .pipe(
        tap(res => {
          console.log('service logout', res);
          this.isLoggedIn = false;
          this.customer = new Customer();
        })
      ).toPromise();
  }

}