import { Component, OnInit } from '@angular/core';
import { CabplanetService } from '../cabplanet.service';
import {Location} from '../location'
import { Router } from '@angular/router';

@Component({
  selector: 'app-listlocation',
  templateUrl: './listlocation.component.html',
  styleUrls: ['./listlocation.component.css']
})
export class ListlocationComponent implements OnInit {
locations:Location[];
  constructor(private _cabservice:CabplanetService,private router: Router) { }

  ngOnInit() {
    this._cabservice.getLocations().subscribe(location =>
      {
        this.locations = location;
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
