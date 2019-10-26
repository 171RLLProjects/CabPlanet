import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CabplanetService } from '../cabplanet.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html'
})
export class AddCustomerComponent implements OnInit {

  customer = new Customer;
 cid:string;

  constructor(private _cabplanetService: CabplanetService,private _router: Router, private _activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.customer.cid = this._activatedRoute.snapshot.paramMap.get("cid");
    this.customer.cfname = this._activatedRoute.snapshot.paramMap.get("cfname");
    this.customer.clname = this._activatedRoute.snapshot.paramMap.get("clname");
    this.customer.dob = this._activatedRoute.snapshot.paramMap.get("dob");
    this.customer.gender = this._activatedRoute.snapshot.paramMap.get("gender");
    this.customer.presentAddress = this._activatedRoute.snapshot.paramMap.get("presentAddress");
    this.customer.permanentAddress = this._activatedRoute.snapshot.paramMap.get("permanentAddress");
    const phoneNumber = this._activatedRoute.snapshot.paramMap.get('phoneNumber');
    this.customer.phoneNumber = +phoneNumber;
    this.customer.email = this._activatedRoute.snapshot.paramMap.get("email");
    this.customer.pwd = this._activatedRoute.snapshot.paramMap.get("pwd");
    if(this.customer.cid !== null){
      this._cabplanetService.getCustomerById(this.customer.cid).subscribe(customer => {
        this.customer = customer;
      });
    }

  }

  addCustomer() {
    console.log('customer called');
    sessionStorage.setItem('cid',this.customer.cid );
    if( this.customer.cid === null){
    this._cabplanetService.addCustomer(this.customer).subscribe(
      customer => {
        this._router.navigate(['customerhome']);
      },
      error => {
        alert(error);
      });
    } else {
      this._cabplanetService.updateCustomer(this.customer).subscribe(
        customer => {
          this._router.navigate(['customerhome']);
        },
        error => {
          alert(error);
        });
    }
  }


}
