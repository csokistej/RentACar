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
        'api/customer/login',
        customer,
        httpOptions
      )
      .pipe(
        tap((customer: Customer) => {
          this.isLoggedIn = true;
          this.customer = customer;
          this.customer.role = 'CUSTOMER'
        })
      )
      .toPromise();
  }

  register(customer: Customer) {
    return this.http.post<Customer>(
      'api/customer/register',
      customer,
      httpOptions
    )
    .pipe(
      tap((customer: Customer) => {
        this.isLoggedIn = true;
        this.customer = customer;
        this.customer.role = 'CUSTOMER'
      })
    )
    .toPromise();
  }

  logout() {
    return this.http.post(
        'api/customer/logout',
        this.customer,
        httpOptions
      )
      .pipe(
        tap(res => {
          console.log('service logout', res);
          this.isLoggedIn = false;
          this.customer = null;
        })
      ).toPromise();
  }

}