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
import { AddAdminComponent } from './add-admin/add-admin.component';
import { AddLocationComponent } from './add-location/add-location.component';
import { ListadminComponent } from './listadmin/listadmin.component';
import { ListlocationComponent } from './listlocation/listlocation.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { CustomerlistComponent } from './customerlist/customerlist.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { CustomerComponent } from './customer/customer.component';
import { CustomerloginComponent } from './customerlogin/customerlogin.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { HomeComponent } from './home/home.component';
import { AddvehicletypeComponent } from './addvehicletype/addvehicletype.component';
import { AddvehicleComponent } from './addvehicle/addvehicle.component';
import { DriverlistComponent } from './driverlist/driverlist.component';
import { VehicletypelistComponent } from './vehicletypelist/vehicletypelist.component';
import { VehiclelistComponent } from './vehiclelist/vehiclelist.component';
import { DriverComponent } from './driver/driver.component';
import { VehicletypeComponent } from './vehicletype/vehicletype.component';
import { VehicleComponent } from './vehicle/vehicle.component';
import { CustomerhomeComponent } from './customerhome/customerhome.component';
import { DriverhomeComponent } from './driverhome/driverhome.component';
import { BookinglistComponent } from './bookinglist/bookinglist.component';
import { BookingComponent } from './booking/booking.component';
import { ShowbookingdetailsComponent } from './showbookingdetails/showbookingdetails.component';
import { PaymentComponent } from './payment/payment.component';

const appRoute: Routes = [
  {path : 'home', component: HomeComponent},
  {path: 'adminlogin', component: AdminloginComponent},
  {path: 'adminhome', component: AdminhomeComponent,
  children: [
  {path: 'addlocation', component: AddLocationComponent},
 {path: 'listlocation', component: ListlocationComponent},
 {path: 'addDriver', component:AdddriverComponent},
 {path: 'addVehicleType', component:AddvehicletypeComponent},
 {path: 'addVehicle', component:AddvehicleComponent},
 {path: 'Driverlist', component:DriverlistComponent},
 {path: 'driver/:did', component:DriverComponent},
 {path: 'vehicletype/:vTypeId', component:VehicletypeComponent},
 {path: 'vehicle/:vid', component:VehicleComponent},
 {path: 'Vehicletypelist', component:VehicletypelistComponent},
 {path: 'Vehiclelist', component:VehiclelistComponent},
 {path: 'addadmin', component: AddAdminComponent},
 {path: 'adminlist', component: ListadminComponent},
 {path: 'bookinglist', component: BookinglistComponent},
]},
{path: 'customerhome', component: CustomerhomeComponent,
children: [
  {path: 'showbookingdetails', component: ShowbookingdetailsComponent},
  {path: 'booking/:bid', component: BookingComponent},
  {path: 'customer/:cid', component: CustomerComponent},
  {path: 'addbooking', component: AddBookingComponent},
 ]},
 {path: 'driverhome', component: DriverhomeComponent,
children: [
  {path: 'bookinglist', component: BookinglistComponent},
  {path: 'customer/:cid', component: CustomerComponent},
  {path: 'addbooking', component: AddBookingComponent},
 ]},
{path: 'driverlogin', component: DriverLoginComponent},
  {path: 'customerlogin', component: CustomerloginComponent},

  {path: 'addCustomer', component: AddCustomerComponent},
  {path: 'customer', component: CustomerlistComponent},
  
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: '**', component: PagenotfoundComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    AdddriverComponent,
    AdminloginComponent,
    DriverLoginComponent,
    AddBookingComponent,
    AddAdminComponent,
    AddLocationComponent,
    ListadminComponent,
    ListlocationComponent,
    HeaderComponent,
    FooterComponent,
    CustomerlistComponent,
    AddCustomerComponent,
    PagenotfoundComponent,
    CustomerComponent,
    CustomerloginComponent,
    AdminhomeComponent,
    HomeComponent,
    AdddriverComponent,
    AddvehicletypeComponent,
    AddvehicleComponent,
    DriverlistComponent,
    VehicletypelistComponent,
    VehiclelistComponent,
    DriverComponent,
    VehicletypeComponent,
    VehicleComponent,
    CustomerhomeComponent,
    DriverhomeComponent,
    BookinglistComponent,
    BookingComponent,
    ShowbookingdetailsComponent,
    PaymentComponent
  
  ],
  imports: [
    BrowserModule,HttpClientModule,FormsModule,ReactiveFormsModule, RouterModule.forRoot(appRoute)
  ],
  providers: [CabplanetService],
  bootstrap: [AppComponent]
})
export class AppModule { }
