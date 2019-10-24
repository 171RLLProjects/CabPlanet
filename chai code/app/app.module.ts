import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { CustomerlistComponent } from './customerlist/customerlist.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { HomeComponent } from './home/home.component';
import { CustomerComponent } from './customer/customer.component';

const appRoute: Routes =[
  {path: 'home', component: HomeComponent},
  {path: 'addCustomer', component: AddCustomerComponent},
  {path: 'customer', component: CustomerlistComponent},
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: '**', component: PagenotfoundComponent},
]

@NgModule({
  declarations: [
    AppComponent,
    CustomerlistComponent,
    AddCustomerComponent,
    PagenotfoundComponent,
    HomeComponent,
    CustomerComponent
  ],
  imports: [
    BrowserModule, FormsModule, HttpClientModule, RouterModule.forRoot(appRoute),ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
