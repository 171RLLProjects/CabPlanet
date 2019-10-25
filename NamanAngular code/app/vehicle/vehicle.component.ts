import { Component, OnInit } from '@angular/core';
import { CabplanetService } from '../cabplanet.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Vehicle } from '../vehicle';

@Component({
  selector: 'app-vehicle',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.css']
})
export class VehicleComponent implements OnInit {
  
  vid : string;
  private sub: any;
  vehicle = new  Vehicle;

  constructor(private _cabplanetService: CabplanetService,private _activatedRoute: ActivatedRoute ,private _router: Router) { }

  ngOnInit() {
    this.sub = this._activatedRoute.params.subscribe(params => {
      this.vid = params['vid']; 
​   });
  this._cabplanetService.getVehicleById(this.vid).subscribe(vehicle => {this.vehicle = vehicle;});
  }

  backTovehiclelist(): void{
    this._router.navigate(['/Vehiclelist']);
  
  }

}
