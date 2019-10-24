import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CabPlanetService } from '../cabplanet.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customerlist',
  templateUrl: './customerlist.component.html',
  styleUrls: ['./customerlist.component.css']
})
export class CustomerlistComponent implements OnInit {

  customer: Customer[];

  constructor(private _cabplanetService: CabPlanetService, private _router: Router) { }

  ngOnInit() {
    this._cabplanetService.getCustomers().subscribe(customer =>{
      this.customer = customer;
    });
  }
  delete(cust: Customer): void {
    this._cabplanetService.deleteCustomer(cust.cid).subscribe(customer =>{
      this.customer = this.customer.filter(u => u !== cust);
    });
  }
  edit(cust: Customer): void {
    console.log('customer edit called');
    this._router.navigate(['/addCustomer', cust]);
  }

}
