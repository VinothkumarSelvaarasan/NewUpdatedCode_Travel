import { Customer } from './customer';
import { TravelDestination } from './travel-destination';
export class Review {
    id!: number;
    reviewDetails!: string;
    customer!: Customer;
    travelDestination!: TravelDestination;
  }