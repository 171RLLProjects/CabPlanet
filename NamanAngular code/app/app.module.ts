import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes} from '@angular/router';


import { AppComponent } from './app.component';
import { AdddriverComponent } from './adddriver/adddriver.component';
import { AddvehicletypeComponent } from './addvehicletype/addvehicletype.component';
import { AddvehicleComponent } from './addvehicle/addvehicle.component';
import { DriverlistComponent } from './driverlist/driverlist.component';
import { VehicletypelistComponent } from './vehicletypelist/vehicletypelist.component';
import { VehiclelistComponent } from './vehiclelist/vehiclelist.component';
import { CabplanetService } from './cabplanet.service';
import { DriverComponent } from './driver/driver.component';
import { VehicletypeComponent } from './vehicletype/vehicletype.component';
import { VehicleComponent } from './vehicle/vehicle.component';

const appRoute: Routes = [
  {path: 'home', component:AppComponent},
  {path: 'addDriver', component:AdddriverComponent},
  {path: 'addVehicleType', component:AddvehicletypeComponent},
  {path: 'addVehicle', component:AddvehicleComponent},
  {path: 'Driverlist', component:DriverlistComponent},
  {path: 'driver/:did', component:DriverComponent},
  {path: 'vehicletype/:vTypeId', component:VehicletypeComponent},
  {path: 'vehicle/:vid', component:VehicleComponent},
  {path: 'Vehicletypelist', component:VehicletypelistComponent},
  {path: 'Vehiclelist', component:VehiclelistComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},

];

@NgModule({
  declarations: [
    AppComponent,
    AdddriverComponent,
    AddvehicletypeComponent,
    AddvehicleComponent,
    DriverlistComponent,
    VehicletypelistComponent,
    VehiclelistComponent,
    DriverComponent,
    VehicletypeComponent,
    VehicleComponent
  ],
  imports: [
    BrowserModule, FormsModule, HttpClientModule, RouterModule.forRoot(appRoute)
  ],
  providers: [CabplanetService],
  bootstrap: [AppComponent]
})
export class AppModule { }
