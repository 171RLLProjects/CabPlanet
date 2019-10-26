import { Component, OnInit } from '@angular/core';
import { Booking } from '../booking';
import { CabplanetService } from '../cabplanet.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bookinglist',
  templateUrl: './bookinglist.component.html',
  styleUrls: ['./bookinglist.component.css']
})
export class BookinglistComponent implements OnInit {

  bookings : Booking[];

  constructor(private _cabplanetService: CabplanetService,private _router: Router) { }

  ngOnInit() {
    this._cabplanetService.getBookings().subscribe( bookings =>
      {
        this.bookings = bookings;
      });
  }
  
  

  backTohome(){
    this._router.navigate(['adminhome']);
  }
}
