import { Component, OnInit } from '@angular/core';
import { CabplanetService } from '../cabplanet.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Vehicletype } from '../vehicletype';

@Component({
  selector: 'app-vehicletype',
  templateUrl: './vehicletype.component.html',
  styleUrls: ['./vehicletype.component.css']
})
export class VehicletypeComponent implements OnInit {

  vTypeId : string;
  private sub: any;
  vehicletype = new Vehicletype;

  constructor(private _cabplanetService: CabplanetService,private _activatedRoute: ActivatedRoute,private _router: Router) { }

  ngOnInit() {

    this.sub = this._activatedRoute.params.subscribe(params => {
      this.vTypeId = params['vTypeId']; 
      console.log(this.vTypeId);
​   });
this._cabplanetService.getVehicleTypeById(this.vTypeId).subscribe(vehicletype => {this.vehicletype = vehicletype;});
  }

  backTovehicletypelist()
  {
    this._router.navigate(['/Vehicletypelist']);
  }


}
