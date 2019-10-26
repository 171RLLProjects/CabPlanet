import { Component, OnInit } from '@angular/core';
import { Booking } from '../booking';
import { Vehicle } from '../vehicle';
import { Vehicletype } from '../vehicletype';
import { CabplanetService } from '../cabplanet.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Route } from '../Route'
import { Location } from '../location';


@Component({
  selector: 'app-add-booking',
  templateUrl: './add-booking.component.html',
  styleUrls: ['./add-booking.component.css']
})
export class AddBookingComponent implements OnInit {
  booking = new Booking;
  vehicle = new Vehicle;
  slocation: Location;
  dlocation: Location;
  vehicles: Vehicle[];
  vehicles1: Vehicle[];
  locations: Location[];
  vehicleTypes: Vehicletype[];
  slid: string;
  dlid: string;
  bid: string;
  vTypeId: string;
  vSeatCapacity: string;
  vehicleType: Vehicletype;
  fare: number;
  route: Route;
  totalFare: number;
  selectedvType: Vehicletype;
  sub: any;
  cid: string;
  slname: string;
  dlname: string;
  rid: string;
  distance : number;
  distance1: string;
  fare1: string;
  vid:string;
  constructor(private _cabplanetService: CabplanetService, private _activatedRoute: ActivatedRoute, private _router: Router) { }

  ngOnInit() {
    this.cid = sessionStorage.getItem('cid');
   
    
    console.log(this.cid);
    this._cabplanetService.getAllVehicletypes().subscribe(vehicleTypes => {
      this.vehicleTypes = vehicleTypes;
    },
      error => {
        alert(error);
      }
    );



    this._cabplanetService.getLocations().subscribe(locations => {
      this.locations = locations;
    },
      error => {
        alert(error);
      }
    );

 

    // this.onSelect(this.vTypeId)


    //  this._cabplanetService.getAllVehicles().subscribe( vehicles =>
    //   {
    //     this.vehicles = vehicles;
    //     for(let veh of vehicles){
    //       console.log(veh.vid+ " "+veh.vName);
    //     }
    //     console.log(this.vehicles+'vehicles');
    //   },error => { alert(error);});


  }

  onSelect(vtypeid) {
    console.log('on select called' + vtypeid);
    this._cabplanetService.getVehicleTypeById(vtypeid).subscribe(data => {
      this.vehicleType = data;
console.log(this.vehicleType+'typebyid')
      this._cabplanetService.getVehiclesByVehicleType(this.vehicleType.vType, this.vehicleType.vSeatCapacity).subscribe
        (data => 
          { 
            this.vehicles = data
            console.log(this.vehicles+'type') 
          });
    });
  }

  calculateFare() {
    this._cabplanetService.getVehicleTypeById(this.vTypeId).subscribe(vehicleType => 
      { this.vehicleType = vehicleType; });
    this._cabplanetService.getfareByVehicleType(this.vehicleType.vType, this.vehicleType.vSeatCapacity)
      .subscribe(fare => { this.fare = fare;
        console.log(fare+'from route');
      sessionStorage.setItem('fare',this.fare.toString());}
        ,
        error => {
          alert(error);
        }
      );
    //console.log(this.slid);
    this._cabplanetService.getLocationById(this.slid).subscribe(slocation => {
      this.slocation = slocation;
      sessionStorage.setItem('slname',slocation.lname);
    });

    this._cabplanetService.getLocationById(this.dlid).subscribe(dlocation => {
      this.dlocation = dlocation;
      sessionStorage.setItem('dlname',dlocation.lname);
    });

   this.slname=sessionStorage.getItem('slname');
   this.dlname=sessionStorage.getItem('dlname');
   console.log(this.slname+' '+this.dlname);

    this._cabplanetService.getRouteByLocation(this.slname, this.dlname)
      .subscribe(route => {
        this.route = route;
        sessionStorage.setItem('rid',this.route.rid);
        //var distance = new Number(10); 
       
        sessionStorage.setItem('distance',route.distance.toString());
        
        
      });
      //console.log(this.distance);
      this.rid=sessionStorage.getItem('rid');
    this.distance1=  sessionStorage.getItem('distance');
    this.distance = +this.distance1;
   this.fare1= sessionStorage.getItem('fare');
   this.fare = +this.fare1;
    console.log(this.fare +' '+ this.distance);
    this.booking.totalFare = this.fare * this.distance;
    console.log(this.booking.totalFare);
  }


  addBooking() {
    console.log(this.cid);

    this.booking = {
      "bid": this.booking.bid,
      "status": "waiting",
      "bookingDate": this.booking.bookingDate,
      "journeyDate":this.booking.journeyDate,
      "totalFare": this.booking.totalFare,
      "customer": {
          "cid": this.cid,
          "cfname": "Neha",
          "clname": "Reddy",
          "dob": "17/01/1998",
          "gender": "female",
          "presentAddress": "pune",
          "permanentAddress": "pune",
          "phoneNumber": 9234507888,
          "email": "neha@gmail.com",
          "pwd": "Neha@123"
      },
      "vehicle": {
          "vid": this.vid,
          "vName": "Nano",
          "vnumber": "MH035555",
          "vehicleType": {
              "vTypeId": "VT_00001",
              "vType": "AC",
              "vSeatCapacity": 3,
              "farePK": 15
          },
          "driver": {
              "did": "DR_00003",
              "dname": "Nitin",
              "address": "Nagpur",
              "contactno": 8834567891,
              "licenseNumber": "MH0220161234578",
              "pwd": "Nitin@1",
              "status": "pending"
          }
      },
      "route": {
          "rid": this.rid,
          "source": {
              "lid": "LO_00002",
              "lname": "Pune"
          },
          "destination": {
              "lid": "LO_00003",
              "lname": "Mumbai"
          },
          "distance": 5,
          "duration": 20,
          "middlePoint": null
      }
  }


    this._cabplanetService.addBooking(this.booking).subscribe(
      data => {
      //  this.bid=data;
        
       
      //  //sessionStorage.removeItem('slname');
      //   sessionStorage.removeItem('dlname');
      //   sessionStorage.removeItem('cid');
      //   sessionStorage.removeItem('distance');
      //   sessionStorage.removeItem('fare');
      //   sessionStorage.removeItem('rid');
        this._router.navigate(['/customerhome/showbookingdetails/',data]);
      }, error => {
        alert(error);
      });

  };
}
