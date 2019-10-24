import { Component, OnInit } from '@angular/core';
import { Admin } from '../admin'
@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent {

  admin = new Admin;
  constructor() { }

  

}
