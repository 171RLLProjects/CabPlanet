import { Component, OnInit } from '@angular/core';
import { Driver } from '../driver';
import { CabplanetService } from '../cabplanet.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-driver-login',
  templateUrl: './driver-login.component.html',
  styleUrls: ['./driver-login.component.css']
})
export class DriverLoginComponent implements OnInit {
 driver = new Driver;
  constructor(private _cabplanetService: CabplanetService,private _activatedRoute: ActivatedRoute,private _router: Router) { }

  ngOnInit() {
  }
  driverLogin(){
    this._cabplanetService.loginDriver(this.driver.contactno,this.driver.pwd).subscribe(
      admin => {
   
       
              this._router.navigate(['driverhome']);
           
      },
      error =>
        alert('Failed') );



  }

}
