import { Component, OnInit } from '@angular/core';
import { Admin } from '../admin'
import { CabplanetService } from '../cabplanet.service';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent {

  admin = new Admin;

  constructor(private _cabplanetService: CabplanetService,private _activatedRoute: ActivatedRoute,private _router: Router) { }
  loginAdmin() {
   this._cabplanetService.adminLogin(this.admin.userName, this.admin.pwd).subscribe(
      admin => {
   
       
              this._router.navigate(['/adminhome']);
           
      },
      error =>
        alert('Failed') );
    // if(this.customer !== null)
    // {
    //   console.log(this.customer);
    //   alert('Success Login');
    //   this.router.navigate(['/customerlist']);
    //       }
    // else{
    //   alert('Failed');
    // }
  }
}


