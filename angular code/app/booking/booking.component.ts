import { Component, OnInit } from '@angular/core';
import { CabplanetService } from '../cabplanet.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Booking } from '../booking';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  bid : string;
  private sub: any;
  booking = new  Booking;

  constructor(private _cabplanetService:CabplanetService, private _router:Router,private _activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    this.sub = this._activatedRoute.params.subscribe(params => {
      this.bid = params['bid']; 
      sessionStorage.setItem('bid',this.bid);
​   });
  this._cabplanetService.getBookingById(this.bid).subscribe(booking => {this.booking = booking;});
  }

 }


