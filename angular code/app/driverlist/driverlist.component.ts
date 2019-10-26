import { Component, OnInit } from '@angular/core';
import { Driver } from '../driver';
import { CabplanetService } from '../cabplanet.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-driverlist',
  templateUrl: './driverlist.component.html'
})
export class DriverlistComponent implements OnInit{

  drivers : Driver[];

  constructor(private _cabplanetService : CabplanetService, private _router : Router) { }

  ngOnInit() {
    this._cabplanetService.getAllDriver().subscribe( drivers =>
      {
        this.drivers = drivers;
      });
  }

  delete(dri: Driver): void{

    this._cabplanetService.deleteDriver(dri.did).subscribe(
      data => 
      {
      this.drivers = this.drivers.filter(u => u !== dri);
    });
  }

  edit(dri: Driver): void{

    console.log('edit employee called');
    this._router.navigate(['/addDriver/',dri]);
  }

  backToFDriverlist()
  {
    this._router.navigate(['adminhome']);
  }
}
