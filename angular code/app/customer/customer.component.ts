import { Component, OnInit } from'@angular/core';
import { Router, ActivatedRoute } from'@angular/router';
import { Customer } from'../customer';
import { CabplanetService } from'../cabplanet.service';
 
@Component({
selector:'app-customer',
templateUrl:'./customer.component.html'
})
export class CustomerComponent implements OnInit {
cid : string;
private sub:any;
customer = new Customer;
constructor(private _cabplanetService:CabplanetService, private _router:Router,private _activatedRoute:ActivatedRoute ) { }
 
ngOnInit() {
this.sub=this._activatedRoute.params.subscribe(params=> {
this.cid=params['cid']; 
    });
this._cabplanetService.getCustomerById(this.cid).subscribe(customer=> {
this.customer=customer;
    });
  }
backToCustomerList():void {
this._router.navigate(['/customer'])
  }
 
}