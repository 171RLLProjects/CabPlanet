import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Customer } from './customer';
import { Observable, throwError  } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CabPlanetService {
  //[x: string]: any;
  headers = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
    };
  currentCustomer: any;
  
    constructor(private _http: HttpClient) { }

    handleError(error) {
      let errorMessage = '';
      if (error.error instanceof ErrorEvent) {
        // client-side error
        errorMessage = `Error: ${error.error.message}`;
      } else {
        // server-side error
        errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
      }
      window.alert(errorMessage);
      return throwError(errorMessage);
    }

    login(phoneNumber: number,pwd: string) {
      console.log('login called' + phoneNumber +' '+pwd);
      return this._http.get<Customer>(`http://172.21.40.22:4545/CabPlanet/loginc/` + phoneNumber + `/` + pwd)
      .pipe(
        retry(1),
        catchError(this.handleError)
      );
    }

    addCustomer(customer: Customer) {
      console.log(customer);
      return this._http.post('http://172.21.40.22:4545/CabPlanet/customer',JSON.stringify(customer),this.headers)
      .pipe(
        retry(1),
        catchError(this.handleError)
      );
    }

    getCustomers(): Observable<Customer[]> {
      console.log('service for getCustomer');
      return this._http.get<Customer[]>('http://172.21.40.22:4545/CabPlanet/customer')
      .pipe(
        retry(1),
        catchError(this.handleError)
      );
    }
    
    deleteCustomer(cid: string) {
      return this._http.delete(`http://172.21.40.22:4545/CabPlanet/delete/` + cid)
      .pipe(
        retry(1),
        catchError(this.handleError)
      );
    }

    updateCustomer(customer: Customer) {
      return this._http.put('http://172.21.40.22:4545/CabPlanet/customer', JSON.stringify(customer),this.headers)
      .pipe(
        retry(1),
        catchError(this.handleError)
      );
    }

    getCustomerById(cid: string) {
      return this._http.get<Customer>(`http://172.21.40.22:4545/CabPlanet/customer/` + cid)
      .pipe(
        retry(1),
        catchError(this.handleError)
      );
    }

    updatePassword(phoneNumber: number , pwd: string) {
      return this._http.put(`http://172.21.40.22:4545/CabPlanet/password/`, +phoneNumber+ `/` +pwd)
      .pipe(
        retry(1),
        catchError(this.handleError)
      );
    }
    logout(){
      localStorage.removeItem('currentCustomer');
      this.currentCustomer.next(null);
    }
    

  }
