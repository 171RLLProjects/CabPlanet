import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `<h1 align="center">{{title}}</h1>
  <div style="padding:15px">
    <ul class="nav nav-tabs">
      <li routerLinkActive="active"><a routerLink='home'>Home</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
      <li><a routerLink='addDriver'>Add Driver</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
      <li><a routerLink='Driverlist'>Driver List</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
      <li><a routerLink='addVehicleType'>Add Vehicle Type</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
      <li><a routerLink='Vehicletypelist'>VehicleType List</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
      <li><a routerLink='addVehicle'>Add Vehicle</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
      <li><a routerLink='Vehiclelist'>Vehicle List</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
      </ul>
      <br/><br/>
      <router-outlet></router-outlet>
      </div>`,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Welcome to Cabplanet';
}
