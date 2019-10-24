import { Component, OnInit } from '@angular/core';
import { CabplanetService } from '../cabplanet.service';
import { Router, ActivatedRoute } from '@angular/router';
import {Location} from '../location';

@Component({
  selector: 'app-add-location',
  templateUrl: './add-location.component.html',
  styleUrls: ['./add-location.component.css']
})
export class AddLocationComponent implements OnInit {
location=new Location;
  constructor(private _cabservice:CabplanetService, private router: Router,private activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    this.location.lid=this.activatedRoute.snapshot.paramMap.get('lid');
    this.location.lname=this.activatedRoute.snapshot.paramMap.get('lname');
  }
  addLocation(){
    console.log("location");
    if(this.location.lid===null){
      this._cabservice.addLocation(this.location).subscribe(
        data => {
          this.router.navigate(['/listlocation']);
        },
       error => {
          alert(error);
       });
    }else{
      this._cabservice.updateLocation(this.location).subscribe(
        data => {
          this.router.navigate(['/listlocation']);
        },
       error => {
          alert(error);
       });
    }
    

  }


}
