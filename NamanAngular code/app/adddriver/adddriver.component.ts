import { Component, OnInit } from '@angular/core';
import { Driver } from '../driver';
import { Router, ActivatedRoute } from '@angular/router';
import { CabplanetService } from '../cabplanet.service';


@Component({
  selector: 'app-adddriver',
  templateUrl: './adddriver.component.html',
  styleUrls: ['./adddriver.component.css']
})
export class AdddriverComponent implements OnInit {

  driver = new Driver;

  constructor(private _cabplanetService: CabplanetService, private _router: Router,  private _activatedRoute: ActivatedRoute) { }

addDriver()
{
  this.driver= {
    "did":this.driver.did,
    "dname":this.driver.dname,
    "address":this.driver.address,
    "contactno":this.driver.contactno,
    "licenseNumber":this.driver.licenseNumber,
    "pwd":this.driver.pwd,
    'status':this.driver.status
  }
  console.log("driver called!")
  if (this.driver.did === null)
  {
    console.log(this.driver.did);
    this._cabplanetService.addDriver(this.driver).subscribe(
      data =>{
        this._router.navigate(['Driverlist'])
      },
      error =>
      {
         alert(error); 
      });}
      else{
        this._cabplanetService.updateDriver(this.driver).subscribe(
          data => {
            this._router.navigate(['Driverlist']);
          },
          error =>
          {
            alert(error);
          });
      }
}


  ngOnInit() {

    this.driver.did = this._activatedRoute.snapshot.paramMap.get('did');
    this.driver.address = this._activatedRoute.snapshot.paramMap.get('address');
    const contactno = this._activatedRoute.snapshot.paramMap.get('contactno');
    this.driver.contactno = +contactno;
    
    this.driver.dname = this._activatedRoute.snapshot.paramMap.get('dname');
    this.driver.licenseNumber = this._activatedRoute.snapshot.paramMap.get('licenseNumber');
    this.driver.pwd = this._activatedRoute.snapshot.paramMap.get('pwd');

  }

}
