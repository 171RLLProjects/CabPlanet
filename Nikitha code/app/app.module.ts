import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { AdddriverComponent } from './adddriver/adddriver.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { RouterModule, Routes} from '@angular/router';
import { DriverLoginComponent } from './driver-login/driver-login.component';
import { AddBookingComponent } from './add-booking/add-booking.component';
import { CabplanetService } from './cabplanet.service';
const appRoute: Routes = [
  {path: 'adminlogin', component: AdminloginComponent},
  {path: 'addbooking', component: AddBookingComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    AdddriverComponent,
    AdminloginComponent,
    DriverLoginComponent,
    AddBookingComponent,
  
  ],
  imports: [
    BrowserModule,HttpClientModule,FormsModule,ReactiveFormsModule, RouterModule.forRoot(appRoute)
  ],
  providers: [CabplanetService],
  bootstrap: [AppComponent]
})
export class AppModule { }
