import { Component, OnInit } from '@angular/core';
import { CabplanetService } from '../cabplanet.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Booking } from '../booking';

@Component({
  selector: 'app-showbookingdetails',
  templateUrl: './showbookingdetails.component.html',
  styleUrls: ['./showbookingdetails.component.css']
})
export class ShowbookingdetailsComponent implements OnInit {
  bid : string;
  private sub: any;
  booking=new Booking;
  constructor(private _cabplanetService: CabplanetService,private _activatedRoute: ActivatedRoute ,private _router: Router) { }

  ngOnInit() {
    this.sub = this._activatedRoute.params.subscribe(params => {
      this.bid = params['bid']; 
      console.log(this.bid);
​   });
  this._cabplanetService.getBookingById(this.bid).subscribe(booking => {this.booking= booking;});
  }

}
