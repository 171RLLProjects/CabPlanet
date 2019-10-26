import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CabplanetService } from '../cabplanet.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-customerlogin',
  templateUrl: './customerlogin.component.html',
  styleUrls: ['./customerlogin.component.css']
})
export class CustomerloginComponent implements OnInit {
  customer =  new Customer; 
  constructor(private _cabplanetService: CabplanetService,private _activatedRoute: ActivatedRoute,private _router: Router) { }
  cid:string;
  ngOnInit() {
  }
  customerLogin(){
    this._cabplanetService.customerlogin(this.customer.phoneNumber,this.customer.pwd).subscribe(
      customer => {
        this.customer=customer;
        console.log(customer.cid);
        sessionStorage.setItem('cid',customer.cid );
      // this.cid = sessionStorage.getItem('cid');
       // console.log("cid" +this.cid);
       
              this._router.navigate(['customerhome']);
           
      },
      error =>
        alert('Failed') );

      

  }


}
