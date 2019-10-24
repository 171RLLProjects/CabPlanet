import { Component, OnInit } from '@angular/core';
import { Booking } from '../booking';
import { Vehicle } from '../vehicle';
import { Vehicletype } from '../vehicletype';
import { CabplanetService } from '../cabplanet.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Route }from '../Route'
@Component({
  selector: 'app-add-booking',
  templateUrl: './add-booking.component.html',
  styleUrls: ['./add-booking.component.css']
})
export class AddBookingComponent implements OnInit {
  booking = new Booking;
  vehicles : Vehicle[];
  locations : Location[];
  vehicleTypes : Vehicletype[];
  slid : string;
  dlid : string;
  bid : string;
  vTypeId : string;
  vSeatCapacity : string;
  vehicleType: Vehicletype;
  fare:number;
  route: Route;
  totalFare:number;
  constructor(private _cabplanetService: CabplanetService,private _activatedRoute: ActivatedRoute) { }

  ngOnInit() {

    this._cabplanetService.getAllVehicletypes().subscribe(vehicleTypes =>{
      this.vehicleTypes = vehicleTypes;},
      error => {
        alert(error);
      }
    );

    this._cabplanetService.getLocations().subscribe(locations =>{
      this.locations = locations;},
      error => {
        alert(error);
      }
    );
   

    //this._cabplanetService.getVehicleTypeById(this.vTypeId).subscribe( vehicleType =>{this.vehicleType = vehicleType;});

    //this._cabplanetService.getVehiclesByVehicleType(this.vehicleType.vType, this.vehicleType.vSeatCapacity).subscribe(vehicles =>{
    //  this.vehicles = vehicles;},
     // error => {
    //    alert(error);
    //  }
   // );

    }  
    //console.log(empid);
    calculateFare(){
      this._cabplanetService.getVehicleTypeById(this.vTypeId).subscribe( vehicleType =>{this.vehicleType = vehicleType;});
      this._cabplanetService.getfareByVehicleType(this.vehicleType.vType, this.vehicleType.vSeatCapacity)
      .subscribe(fare =>{ this.fare = fare}
      ,
        error => {
          alert(error);
        }
      );
    this._cabplanetService.getDistanceBySourceAndDestination(this.slid,this.dlid)
    .subscribe(route => {this.route= route;});
   

      this.booking.totalFare =this.fare * this.route.distance;
  }

  addBooking(){

    this.booking = {
      "bid":"BI_00023",
      "status":this.booking.status,
      "bookingDate":this.booking.bookingDate,
      "journeyDate":this.booking.journeyDate,
      "totalFare":this.booking.totalFare,
      "customer":{
	      "cid":"CU_00002",
	      "cfname":"bachiraju",
	      "clname":"ramya",
	      "dob":"14/09/1997",	
	      "gender":"female",
      	"presentAddress":"vijayawada",
	      "permanentAddress":"vijayawada",
	      "phoneNumber":9000007888,
	      "email":"ramyabachiraju@gmail.com",
	      "pwd":"Ramya@123"
      },
      "vehicle":{
	      "vid":this.vTypeId,
      	"vName":"Swift",
	      "vnumber":"MH022343",
	      "vehicleType":{
		    "vTypeId":"VT_00002",
		    "vType":"AC",
		    "vSeatCapacity":5,
		    "farePK":20.0},
	      "driver":{
		      "did":"DR_00001",
		      "dname":"Bhargav",
		      "address":"Vijaywada",
		      "contactno":1234567891,
		      "licenseNumber":"MH0220191234567",
		      "pwd":"Bhargav@1"
          }
},

"route":{
	"rid":this.route.rid,
	"source":{
		"lid":"LO_00001",
		"lname":"Pune"
		},
	"destination":{
		"lid":"LO_00001",
		"lname":"Pune"
		
	},
	"distance":4.5,
	"duration":10,
	"middlePoint":{
		"lid":"LO_00003",
		"lname":"Bangalore"
	}
  }


  }
};
}
