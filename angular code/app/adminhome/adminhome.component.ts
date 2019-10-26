import { Component, OnInit } from '@angular/core';
import { CabplanetService } from '../cabplanet.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit {

  constructor(private _cabplanetService: CabplanetService, private _router: Router) { }

  ngOnInit() {
  }
  onLogout(){
    this._cabplanetService.deleteToken();
    this._router.navigate(['/home']);
  }
}
