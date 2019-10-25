import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders } from '@angular/common/http';
import { Driver } from './driver';
import { Observable,throwError } from 'rxjs';
import { Vehicletype } from './vehicletype';
import { retry, catchError } from 'rxjs/operators';
import { Vehicle } from './vehicle';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CabplanetService { 

  headers = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  
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

  currentCustomer : any;

  constructor(private _http: HttpClient,private router:Router) { }

// DRIVER OPERATIONS==================================================================================================
  
//REMEMBER TO CHANGE ALL URLS

//ADD DRIVER  

  addDriver(driver : Driver){
    
    console.log(driver);
    return this._http.post('http://172.21.40.22:4545/CabPlanet/driver',
    JSON.stringify(driver),this.headers).pipe(
      retry(1),
      catchError(this.handleError));;
    }


// DELETE DRIVER

deleteDriver(did: string){
  console.log("delete for driver called!");
  return this._http.delete(`http://172.21.40.22:4545/CabPlanet/driverdelete/`+did).pipe(
    retry(1),
    catchError(this.handleError));;

}

//UPDATE DRIVER

updateDriver(driver: Driver){
console.log("driver");
  return this._http.put('http://172.21.40.22:4545/CabPlanet/driverupdate',JSON.stringify(driver),this.headers).pipe(
    retry(1),
    catchError(this.handleError));;
}

// GET DRIVER DETAILS BY ID

getDriverByid(did: string) {
  console.log('service for getDriverByID');
  return this._http.get<Driver>(`http://172.21.40.22:4545/CabPlanet/driver/`+did).pipe(
    retry(1),
    catchError(this.handleError));;

}

// GET ALL DRIVERS

getAllDriver(): Observable<Driver[]>
{
  console.log("Driver List!");
  return this._http.get<Driver[]>('http://172.21.40.22:4545/CabPlanet/dri').pipe(
    retry(1),
    catchError(this.handleError));;
}

//LOGIN FOR DRIVER

loginDriver(contactno: number,password: string) {
  console.log('login for driver called!');
  return this._http.get<Driver>(`http://172.21.40.22:4545/CabPlanet/login/`+contactno+`/`+password).pipe(
    retry(1),
    catchError(this.handleError));

}

// UPDATE PASSWORD

updatepasswordOfDriver(did: string,password: string,driver :Driver){
console.log("update password for driver called!");
return this._http.put(`http://172.21.40.22:4545/CabPlanet/driverpassword/`+did+`/`+password,JSON.stringify(driver),this.headers).pipe(
  retry(1),
  catchError(this.handleError));;
}




//VEHICLETYPE OPERATIONS=========================================================================================================

//ADD VEHICLETYPE

addVehicleType(vehicletype : Vehicletype){
    
  console.log(vehicletype);
  return this._http.post('http://172.21.40.22:4545/CabPlanet/vehicletype',
  JSON.stringify(vehicletype),this.headers).pipe(
    retry(1),
    catchError(this.handleError));;
  }

//UPDATE VEHICLE TYPE

updateVehicleType(vehicletype : Vehicletype)
{
  console.log(vehicletype);
  return this._http.put('http://172.21.40.22:4545/CabPlanet/vehicletypeupdate',JSON.stringify(vehicletype),this.headers).pipe(
    retry(1),
    catchError(this.handleError));;
}

//DELETE VEHICLE TYPE

deleteVehicleType(vTypeId: string){
  console.log(" service for delete for vehicletype called!");
  return this._http.delete(`http://172.21.40.22:4545/CabPlanet/vehicletypedelete/`+vTypeId).pipe(
    retry(1),
    catchError(this.handleError));

}

//GET ALL VEHICLETYPES

getAllVehicletypes(): Observable<Vehicletype[]>
{
  console.log("SERVICE For VehicleType List!");
  return this._http.get<Vehicletype[]>('http://172.21.40.22:4545/CabPlanet/vegtypes').pipe(
    retry(1),
    catchError(this.handleError));;
}





//GET VEHICLETYPEBYID

getVehicleTypeById(vTypeId: string)
{
  console.log("service for get vehicle type by id!");
  return this._http.get<Vehicletype>(`http://172.21.40.22:4545/CabPlanet/vehicletypedetails/`+vTypeId).pipe(
    retry(1),
    catchError(this.handleError));;
}



//VEHICLE OPERATIONS================================================================================================

//ADD VEHICLETYPE

addVehicle(vehicle : Vehicle){
    
  console.log(vehicle);
  return this._http.post('http://172.21.40.22:4545/CabPlanet/vehicle',
  JSON.stringify(vehicle),this.headers).pipe(
    retry(1),
    catchError(this.handleError));;
  }

//UPDATE VEHICLE TYPE

updateVehicle(vehicle : Vehicle)
{
  console.log(vehicle);
  return this._http.put('http://172.21.40.22:4545/CabPlanet/vehicleupdate',JSON.stringify(vehicle),this.headers).pipe(
    retry(1),
    catchError(this.handleError));;
}

//DELETE VEHICLE TYPE

deleteVehicle(vid: string){
  console.log(" service for delete for vehicle called!");
  return this._http.delete(`http://172.21.40.22:4545/CabPlanet/vehicledelete/`+vid).pipe(
    retry(1),
    catchError(this.handleError));

}

//GET ALL VEHICLETYPES

getAllVehicles(): Observable<Vehicle[]>
{
  console.log("SERVICE For Vehicle List!");
  return this._http.get<Vehicle[]>('http://172.21.40.22:4545/CabPlanet/vehicles').pipe(
    retry(1),
    catchError(this.handleError));;
}

//GET VEHICLES BY VEHICLE TYPE

getVehiclesByVehicleType(vtype: string, vseatcapacity: number): Observable<Vehicle[]>
{
  console.log("service for showing fare!");
  return this._http.get<Vehicle[]>(`http://172.21.40.22:4545/CabPlanet/vehicles/`+vtype+`/`+vseatcapacity).pipe(
    retry(1),
    catchError(this.handleError));;
}

//GET VEHICLE BY ID

getVehicleById(vid: String)
{
  console.log("service for get vehicle by id!");
  return this._http.get<Vehicle>(`http://172.21.40.22:4545/CabPlanet/vehicledetails/`+vid).pipe(
    retry(1),
    catchError(this.handleError));;
} 

//GET VEHICLE BY DRIVER ID

getVehicleByDriverId(did: String)
{
  console.log("service for get vehicle by driver id!");
  return this._http.get<Vehicle>(`http://172.21.40.22:4545/CabPlanet/vehicledetailsdid/`+did).pipe(
    retry(1),
    catchError(this.handleError));;
} 

//logout

logout()
{
  console.log("logout called");
    localStorage.removeItem("currentCustomer");

    this.currentCustomer.next(null);
  
  }

  
}




