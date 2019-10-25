import { Component, OnInit } from '@angular/core';
import { CabplanetService } from '../cabplanet.service';
import { Vehicle } from '../vehicle';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vehiclelist',
  templateUrl: './vehiclelist.component.html',
  styleUrls: ['./vehiclelist.component.css']
})
export class VehiclelistComponent implements OnInit {

  vehicles : Vehicle[]; 
  constructor(private _cabplanetService : CabplanetService,private _router : Router) { }

  ngOnInit() {
    this._cabplanetService.getAllVehicles().subscribe( vehicles =>
      {
        this.vehicles = vehicles;
      });

  }


  delete(veh: Vehicle): void{

    this._cabplanetService.deleteVehicle(veh.vid).subscribe(
      data => 
      {
      this.vehicles = this.vehicles.filter(u => u !== veh);
    });
  }

  edit(veh: Vehicle): void{

    console.log('edit vehicle called');
    this._router.navigate(['/addVehicle/',veh]);
  }

}
