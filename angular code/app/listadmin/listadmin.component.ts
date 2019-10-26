import { Component, OnInit } from '@angular/core';
import { CabplanetService } from '../cabplanet.service';
import { Router } from '@angular/router';
import { Admin } from '../admin';

@Component({
  selector: 'app-listadmin',
  templateUrl: './listadmin.component.html'
})
export class ListadminComponent implements OnInit {
admins:Admin[];
  constructor(private _cabservice: CabplanetService,private _router: Router) { }

  ngOnInit() {
    this._cabservice.getAdmins().subscribe(
admin=>{
this.admins=admin;
}
  );
  }
  delete(admin:Admin):void{
    this._cabservice.deleteAdmin(admin.aid).subscribe(admin=>{
      this.admins=this.admins.filter(u=>u!==admin);
    });
  }
  backToFAdminlist(){
    
      this._router.navigate(['adminhome']);
    
  }



}
