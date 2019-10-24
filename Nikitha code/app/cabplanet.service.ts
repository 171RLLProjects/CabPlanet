import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { retry, catchError } from 'rxjs/operators';
import { throwError, Observable } from 'rxjs';
import { Vehicletype } from './vehicletype';
import { Vehicle } from './vehicle';
import { Route } from './route';
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
  constructor(private _http: HttpClient) { }
  getLocations():Observable<Location[]>{
    return this._http.get<Location[]>('http://172.21.40.22:4545/CabPlanet/locationget').pipe(
      retry(1),
      catchError(this.handleError)
    );
    }

    getAllVehicletypes(): Observable<Vehicletype[]>
    {
      console.log("SERVICE For VehicleType List!");
      return this._http.get<Vehicletype[]>('http://172.21.40.22:4545/CabPlanet/vegtypes').pipe(
      retry(1),
      catchError(this.handleError));;
    }
    getVehiclesByVehicleType(vtype: string, vseatcapacity: number): Observable<Vehicle[]>
    {
      console.log("service for showing fare!");
      return this._http.get<Vehicle[]>(`http://172.21.40.22:4545/CabPlanet/vehicles`+vtype+`/`+vseatcapacity).pipe(
      retry(1),
      catchError(this.handleError));;
}
getVehicleTypeById(vtypeid: string)
{
  console.log("service for get vehicle type by id!");
  return this._http.get<Vehicletype>(`http://172.21.40.22:4545/CabPlanet/vehicledetails`+vtypeid).pipe(
    retry(1),
    catchError(this.handleError));;
}

getfareByVehicleType(vtype: string, vseatcapacity: number)
{
  console.log("service for showing fare!");
  return this._http.get<number>(`http://172.21.40.22:4545/CabPlanet/faretype/`+vtype+`/`+vseatcapacity);
}


getDistanceBySourceAndDestination(source: string, destination:string){
  return this._http.get<Route>(`http://172.21.40.22:4545/CabPlanet/getdistenceroute/`+source+'/'+destination);
}
}
