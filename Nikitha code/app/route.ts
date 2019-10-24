import { Location }from './location'

export class Route {
    rid : string;
    distance : number;
    duration : number;
    destination : Location;
    source : Location;
    middlePoint : Location;
}
