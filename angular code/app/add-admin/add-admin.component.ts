import { Component, OnInit } from '@angular/core';
import { CabplanetService } from '../cabplanet.service';
import { Router, ActivatedRoute } from '@angular/router';
import {Location} from '../location'
import { Admin } from '../admin';
@Component({
  selector: 'app-add-admin',
  templateUrl: './add-admin.component.html'
})
export class AddAdminComponent implements OnInit {
admin=new Admin;
  constructor(private _cabservice:CabplanetService,private router: Router,private activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    
this.admin.aid=this.activatedRoute.snapshot.paramMap.get('aid');
this.admin.userName=this.activatedRoute.snapshot.paramMap.get('userName');
  }
  addAdmin(){
    
    if(this.admin.aid===null){
      this._cabservice.addAdmin(this.admin).subscribe(
        admin => {
          this.router.navigate(['/adminhome/listadmin']);
        },
       error => {
          alert(error);
       });
    }
    }
    

  }

