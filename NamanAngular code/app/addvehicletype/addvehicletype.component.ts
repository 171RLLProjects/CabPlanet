import { Component, OnInit } from '@angular/core';
import { Vehicletype } from '../vehicletype';
import { CabplanetService } from '../cabplanet.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-addvehicletype',
  templateUrl: './addvehicletype.component.html',
  styleUrls: ['./addvehicletype.component.css']
})
export class AddvehicletypeComponent implements OnInit {
  
  vehicletype = new Vehicletype;
  constructor(private _cabplanetService: CabplanetService, private _router: Router,  private _activatedRoute: ActivatedRoute) { }

  addVehicleType(){

    console.log('vehicletype component called');
    if (this.vehicletype.vTypeId === null)
    {
      this._cabplanetService.addVehicleType(this.vehicletype).subscribe(
        data =>{
          this._router.navigate(['Vehicletypelist'])
        },
        error =>
        {
           alert(error); 
        });}
        else{
          this._cabplanetService.updateVehicleType(this.vehicletype).subscribe(
            data => {
              this._router.navigate(['Vehicletypelist']);
            },
            error =>
            {
              alert(error);
            });
        }

   }

  ngOnInit() {

    this.vehicletype.vTypeId = this._activatedRoute.snapshot.paramMap.get('vTypeId');
     if(this.vehicletype.vTypeId !== null){
    const farePK = this._activatedRoute.snapshot.paramMap.get('farePK');
    this.vehicletype.farePK = +farePK; 
    const vSeatCapacity = this._activatedRoute.snapshot.paramMap.get('vSeatCapacity');
     this.vehicletype.vSeatCapacity = +vSeatCapacity;
    this.vehicletype.vType = this._activatedRoute.snapshot.paramMap.get('vType');
     }

  }

  
}
