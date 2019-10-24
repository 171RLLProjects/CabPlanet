import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  showDetails = false;

  constructor(private _router: Router) { }

  ngOnInit() {
  }
  toggleDetails(): void{
    this.showDetails = !this.showDetails;
  }
  
  backToEmployeeList(): void {
    this._router.navigate(['/customer'])
  }

}
