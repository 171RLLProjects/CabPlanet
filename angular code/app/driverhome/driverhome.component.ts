import { Component, OnInit } from '@angular/core';
import { Vehicle } from '../vehicle';

@Component({
  selector: 'app-driverhome',
  templateUrl: './driverhome.component.html',
  styleUrls: ['./driverhome.component.css']
})
export class DriverhomeComponent implements OnInit {
  vehicle:Vehicle;
  constructor() { }

  ngOnInit() {
  }

  viewvehicle(){

  }
}
