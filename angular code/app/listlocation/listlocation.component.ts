import { Component, OnInit } from '@angular/core';
import { CabplanetService } from '../cabplanet.service';

import { Router } from '@angular/router';
import { Location } from '../location';

@Component({
  selector: 'app-listlocation',
  templateUrl: './listlocation.component.html'
})
export class ListlocationComponent implements OnInit {
  locations : Location[];
  constructor(private _cabservice:CabplanetService,private router: Router) { }

  ngOnInit() {
    this._cabservice.getLocations().subscribe(locations =>
      {
        this.locations = locations;
      } 
    );

  }
  delete(loc:Location):void{
    this._cabservice.deleteLocation(loc.lid).subscribe(location=>{
      this.locations=this.locations.filter(u=>u!==loc);
    });
  }
  edit(loc:Location):void{
    console.log('edit called');
    this.router.navigate(['/addlocation/',loc]);
  }
  
}
