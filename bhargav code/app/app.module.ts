import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import{ RouterModule,Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { CabplanetService } from './cabplanet.service';
import { AddAdminComponent } from './add-admin/add-admin.component';
import { AddLocationComponent } from './add-location/add-location.component';
import { ListadminComponent } from './listadmin/listadmin.component';
import { ListlocationComponent } from './listlocation/listlocation.component';
import { DriverloginComponent } from './driverlogin/driverlogin.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';


const appRoute: Routes = [
  {path: 'home',  component: AppComponent},
  
  {path: 'addlocation', component: AddLocationComponent},
  {path: 'addadmin', component: AddAdminComponent},
  {path: 'listlocation', component: ListlocationComponent},
  {path: 'listadmin', component: ListadminComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
];


@NgModule({
  declarations: [
    AppComponent,
    AddAdminComponent,
    AddLocationComponent,
    ListadminComponent,
    ListlocationComponent,
    DriverloginComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,RouterModule.forRoot(appRoute),FormsModule,HttpClientModule,ReactiveFormsModule
  ],
  providers: [CabplanetService],
  bootstrap: [AppComponent]
})
export class AppModule { }
