import { Customer } from "./customer";
import { Vehicle } from "./vehicle";
import { Route } from "./route";
import { Driver } from "./driver";
export class Booking {

    bid: string;
    status: string;
    bookingDate: string;
    journeyDate: string;
    totalFare: number;
    customer: Customer; 
    vehicle: Vehicle;
    route: Route;
   
}
