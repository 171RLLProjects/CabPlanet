import { Component, OnInit } from '@angular/core';
import { Vehicletype } from '../vehicletype';
import { CabplanetService } from '../cabplanet.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vehicletypelist',
  templateUrl: './vehicletypelist.component.html',
  styleUrls: ['./vehicletypelist.component.css']
})
export class VehicletypelistComponent implements OnInit {

  vehicletypes : Vehicletype[];

  constructor(private _cabplanetService : CabplanetService,private _router : Router) { }

  ngOnInit() {
    this._cabplanetService.getAllVehicletypes().subscribe( vehicletypes =>
      {
        this.vehicletypes = vehicletypes;
      });

  }


  delete(veht: Vehicletype): void{

    this._cabplanetService.deleteVehicleType(veht.vTypeId).subscribe(
      data => 
      {
      this.vehicletypes = this.vehicletypes.filter(u => u !== veht);
    });
  }


  edit(veht: Vehicletype): void{

    console.log('edit vehicletype called');
    this._router.navigate(['/addVehicleType/',veht]);
  }

}
