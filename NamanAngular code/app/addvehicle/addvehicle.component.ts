import { Component, OnInit } from '@angular/core';
import { Vehicle } from '../vehicle';

import { Vehicletype } from '../vehicletype';
import { CabplanetService } from '../cabplanet.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Driver } from '../driver';

@Component({
  selector: 'app-addvehicle',
  templateUrl: './addvehicle.component.html',
  styleUrls: ['./addvehicle.component.css']
})
export class AddvehicleComponent implements OnInit {
  vehicle = new Vehicle;
  drivers: Driver[];
  vehicletypes: Vehicletype[];
  did: string;
  vTypeId: string;
  constructor(private _cabplanetService: CabplanetService, private _router: Router,  private _activatedRoute: ActivatedRoute) { }

ngOnInit() {

  this._cabplanetService.getAllDriver().subscribe(drivers =>
    {
      this.drivers = drivers;
    },error => { alert(error); });


    this._cabplanetService.getAllVehicletypes().subscribe( vehicletypes =>
      {
        this.vehicletypes = vehicletypes;
       },error => { alert(error); });

        this.vehicle.vid = this._activatedRoute.snapshot.paramMap.get('vid');

        if(this.vehicle.vid !== null)
        {
          this._cabplanetService.getVehicleById(this.vehicle.vid).subscribe( vehicle => 
         {
              this.vehicle = vehicle;
              this.did = this.vehicle.driver.did;
              this.vTypeId = this.vehicle.vehicleType.vTypeId;


         });
        }



  }


addVehicle()
{
  console.log('Vehicle called!!');
    console.log(this.did);
    console.log(this.vTypeId);
this.vehicle ={

'vid': this.vehicle.vid,
'vName': this.vehicle.vName,
'vnumber': this.vehicle.vnumber,
'driver':
{
  'did': this.did,
  'dname': 'cmp',
  'contactno':9876543210,
  'licenseNumber':'m434pop',
  'address':'ndsjdhjfbd',
  'pwd':'bdksjabdkj',
  'status':'dfd'
},
'vehicleType':
{
  'vTypeId':this.vTypeId,
  'farePK':87,
  'vSeatCapacity':7,
  'vType':'yh'
}};

if(this.vehicle.vid === null){
  this._cabplanetService.addVehicle(this.vehicle).subscribe(
    data => {
      this._router.navigate(['/Vehiclelist']);
    },error =>
    { alert(error);
    });}
    else{
      this._cabplanetService.updateVehicle(this.vehicle).subscribe(
        data => {
          this._router.navigate(['/Vehiclelist']);
        },
        error =>
        {
          alert(error);
        });
    }

  }

}


