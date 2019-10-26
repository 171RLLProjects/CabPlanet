import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { retry, catchError } from 'rxjs/operators';
import { throwError, Observable } from 'rxjs';
import { Vehicletype } from './vehicletype';
import { Vehicle } from './vehicle';
import { Route } from './route';
import { Admin } from './admin';
import { Customer } from './customer';
import { Location } from './location';
import { Driver } from './driver';
import { Booking } from './booking';

@Injectable({
  providedIn: 'root'
})
export class CabplanetService {
  headers = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json'
    })
  };

  currentUser: any;

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


  constructor(private _http: HttpClient) { }
  deleteToken() {
    localStorage.removeItem('token');
  }

  getLocations():Observable<Location[]>{
    return this._http.get<Location[]>('http://172.21.40.22:4545/CabPlanet/locationget').pipe(
      retry(1),
      catchError(this.handleError)
    );
    }

    getAllVehicletypes(): Observable<Vehicletype[]>
    {
     // console.log("SERVICE For VehicleType List!");
      return this._http.get<Vehicletype[]>('http://172.21.40.22:4545/CabPlanet/vegtypes').pipe(
      retry(1),
      catchError(this.handleError));;
    }
    getVehiclesByVehicleType(vtype: string, vseatcapacity: number): Observable<Vehicle[]>
    {
     // console.log("service for showing fare!");
      return this._http.get<Vehicle[]>(`http://172.21.40.22:4545/CabPlanet/vehicles/`+vtype+`/`+vseatcapacity).pipe(
      retry(1),
      catchError(this.handleError));;
}
getVehicleTypeById(vtypeid: string)
{
  console.log("service for get vehicle type by id!");
  return this._http.get<Vehicletype>(`http://172.21.40.22:4545/CabPlanet/vehicletypedetails/`+vtypeid).pipe(
    retry(1),
    catchError(this.handleError));;
}

getfareByVehicleType(vtype: string, vseatcapacity: number)
{
  console.log("service for showing fare!");
  return this._http.get<number>(`http://172.21.40.22:4545/CabPlanet/faretype/`+vtype+`/`+vseatcapacity);
}

getAllVehicles(): Observable<Vehicle[]>
{
  console.log("SERVICE For Vehicle List!");
  return this._http.get<Vehicle[]>('http://172.21.40.22:4545/CabPlanet/vehicles').pipe(
    retry(1),
    catchError(this.handleError));;
}

// getAllVehiclesBy(): Observable<Vehicle[]>
// {
//   console.log("SERVICE For Vehicle List!");
//   return this._http.get<Vehicle[]>('http://172.21.40.22:4545/CabPlanet/vehicles').pipe(
//     retry(1),
//     catchError(this.handleError));;
// }

getRouteByLocation(source: string, destination:string){
  return this._http.get<Route>(`http://172.21.40.22:4545/CabPlanet/route/`+source+'/'+destination);
}

addAdmin(admin:Admin){
  return this._http.post('http://172.21.40.22:4545/CabPlanet/admin',JSON.stringify(admin),this.headers).pipe(
    retry(1),
    catchError(this.handleError)
  );
}
deleteAdmin(aid:string)
{
  return this._http.delete(`http://172.21.40.22:4545/CabPlanet/admin/`+aid).pipe(
    retry(1),
    catchError(this.handleError)
  );
}
getAdmins():Observable<Admin[]>{
  return this._http.get<Admin[]>('http://172.21.40.22:4545/CabPlanet/adminget').pipe(
    retry(1),
    catchError(this.handleError)
  );
}
getAdminById(aid:string):Observable<Admin>{
  return this._http.get<Admin>(`http://172.21.40.22:4545/CabPlanet/adminid/`+aid).pipe(
    retry(1),
    catchError(this.handleError)
  );
}
adminLogin(userName:string,pwd:string){
  console.log('login called' + userName +' '+pwd);
    return this._http.get<Admin>(`http://172.21.40.22:4545/CabPlanet/adminlogin/` + userName + `/` + pwd)
    .pipe(
      retry(1),
      catchError(this.handleError)
    );
}

addLocation(location:Location){
  return this._http.post('http://172.21.40.22:4545/CabPlanet/location',JSON.stringify(location),this.headers).pipe(
    retry(1),
    catchError(this.handleError)
  );

}
updateLocation(location:Location){
  return this._http.put(`http://172.21.40.22:4545/CabPlanet/locationu`,JSON.stringify(location),this.headers).pipe(
    retry(1),
    catchError(this.handleError)
  );
}
deleteLocation(lid:string){
  return this._http.delete(`http://172.21.40.22:4545/CabPlanet/location/`+lid).pipe(
    retry(1),
    catchError(this.handleError)
  );
}

getLocationById(lid:string){
return this._http.get<Location>(`http://172.21.40.22:4545/CabPlanet/locationid/`+lid).pipe(
  retry(1),
  catchError(this.handleError)
);
}
getlocationByName(lname:string){
  return this._http.get<Location>(`http://172.21.40.22:4545/CabPlanet/locationun/`+lname).pipe(
    retry(1),
    catchError(this.handleError)
  );
}

// logout(){
//   localStorage.removeItem('currentUser');
//   //this.currentUserSubject.next(null);
//   //this.currentPassenger.next(null);
//   //this.currentTicket.next(null);
// }

addRoute(route:Route){
  return this._http.post('http://172.21.40.22:4545/CabPlanet/route',JSON.stringify(route),this.headers).pipe(
    retry(1),
    catchError(this.handleError)
  );

}
getRouteById(rid:string):Observable<Route>{
  return this._http.get<Route>('http://172.21.40.22:4545/CabPlanet/route/'+rid).pipe(
    retry(1),
    catchError(this.handleError)
  );
}
getRoutes():Observable<Route[]>{
  return this._http.get<Route[]>(`http://172.21.40.22:4545/CabPlanet/route`).pipe(
    retry(1),
    catchError(this.handleError)
  );
}
getDistanceByRid(rid:string):Observable<Route>{
  return this._http.get<Route>('http://172.21.40.22:4545/CabPlanet/route/'+rid).pipe(
    retry(1),
    catchError(this.handleError)
  );
}
getLocationMiddlePointByRid(rid:string):Observable<Route>{
return this._http.get<Route>('http://172.21.40.22:4545/CabPlanet/route/'+rid).pipe(
    retry(1),
    catchError(this.handleError)
  );

}

customerlogin(phoneNumber: number,pwd: string) {
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

// getAllVehicletypes(): Observable<Vehicletype[]>
// {
// console.log("SERVICE For VehicleType List!");
// return this._http.get<Vehicletype[]>('http://172.21.40.22:4545/CabPlanet/vegtypes').pipe(
//   retry(1),
//   catchError(this.handleError));;
// }





//GET VEHICLETYPEBYID

// getVehicleTypeById(vTypeId: string)
// {
// console.log("service for get vehicle type by id!");
// return this._http.get<Vehicletype>(`http://172.21.40.22:4545/CabPlanet/vehicletypedetails/`+vTypeId).pipe(
//   retry(1),
//   catchError(this.handleError));;
// }



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

// getAllVehicles(): Observable<Vehicle[]>
// {
// console.log("SERVICE For Vehicle List!");
// return this._http.get<Vehicle[]>('http://172.21.40.22:4545/CabPlanet/vehicles').pipe(
//   retry(1),
//   catchError(this.handleError));;
// }

//GET VEHICLES BY VEHICLE TYPE

getVehiclesByVehicleTypeN(vtype: string, vseatcapacity: number): Observable<Vehicle[]>
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

addBooking(booking : Booking){
  return this._http.post('http://172.21.40.22:4545/CabPlanet/booking',
  JSON.stringify(booking),this.headers).pipe(
  retry(1),
  catchError(this.handleError));;

}
getBookings(): Observable<Booking[]>
{
  console.log('service for getbooking');
  return this._http.get<Booking[]>('http://172.21.40.22:4545/CabPlanet/booking');
}

getBookingById(bid: string)
{
  console.log('service for getemployee');
  return this._http.get<Booking>(`http://172.21.40.22:4545/CabPlanet/bookingb/`+bid);
}

//logout

// logout()
// {
// console.log("logout called");
//   localStorage.removeItem("currentCustomer");

//   this.currentCustomer.next(null);

// }




}
