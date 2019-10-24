import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template:  `<h1>Welcome to Cab Planet</h1>
  <div style="padding:15px">
 <ul class="nav nav-tabs">
 <li routerLinkActive="active"><a routerLink='home'>Home</a></li>&nbsp;&nbsp;&nbsp;&nbsp;

 <li><a routerLink='addadmin'>Add Admin</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
 <li><a routerLink='addlocation'>Add Location</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
 <li><a routerLink='listadmin'>Get Admins</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
 <li><a routerLink='listlocation'>Get Location</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
 </ul>
 <br/><br/>
 <app-header></app-header>
 <router-outlet></router-outlet>
 <app-footer></app-footer>
        
 </div>
  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'CabPlanet';
}
