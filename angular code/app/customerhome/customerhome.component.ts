import { Component, OnInit } from '@angular/core';
import { CabplanetService } from '../cabplanet.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../customer';

@Component({
  selector: 'app-customerhome',
  templateUrl: './customerhome.component.html',
  styleUrls: ['./customerhome.component.css']
})
export class CustomerhomeComponent implements OnInit {

  constructor(private _cabplanetService: CabplanetService,private _activatedRoute: ActivatedRoute,private _router: Router) { }
 

  ngOnInit() {
    


  }
  onLogout(){
    this._cabplanetService.deleteToken();
    this._router.navigate(['/home']);
  }
}
