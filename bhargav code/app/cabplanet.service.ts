import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { throwError, Observable } from 'rxjs';
import { Admin } from './admin';
import { Route } from './route';
import { Location } from './location'
import { retry, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CabplanetService {
  headers = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  
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
getLocations():Observable<Location[]>{
return this._http.get<Location[]>('http://172.21.40.22:4545/CabPlanet/locationget').pipe(
  retry(1),
  catchError(this.handleError)
);
}
getLocatioById(lid:string):Observable<Location>{
return this._http.get<Location>(`http://172.21.40.22:4545/CabPlanet/locationgetid/`+lid).pipe(
  retry(1),
  catchError(this.handleError)
);
}
getlocationByName(lname:string){
  return this._http.get(`http://172.21.40.22:4545/CabPlanet/locationun/`+lname).pipe(
    retry(1),
    catchError(this.handleError)
  );
}

logout(){
  localStorage.removeItem('currentUser');
  //this.currentUserSubject.next(null);
  //this.currentPassenger.next(null);
  //this.currentTicket.next(null);
}

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
}


