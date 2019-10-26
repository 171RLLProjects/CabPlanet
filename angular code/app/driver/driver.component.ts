import { Component, OnInit } from '@angular/core';
import { CabplanetService } from '../cabplanet.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Driver } from '../driver';

@Component({
  selector: 'app-driver',
  templateUrl: './driver.component.html'
})
export class DriverComponent implements OnInit {

  did : string;
  private sub: any;
  driver= new  Driver;
  constructor(private _cabplanetService: CabplanetService,private _activatedRoute: ActivatedRoute ,private _router: Router) { }

  ngOnInit() {
   
    this.sub = this._activatedRoute.params.subscribe(params => {
      this.did = params['did']; 
​   });
  this._cabplanetService.getDriverByid(this.did).subscribe(driver => {this.driver= driver;});
 }


 backToDriverlist(): void{
  this._router.navigate(['/Driverlist']);

}

}
