export class ReviewData {
    reviewDetails: string;
    customer: {
      id: number;
    };
    travelDestination: {
      id: number;
    };
  
    constructor(reviewDetails: string, customerId: number, destinationId: number) {
      this.reviewDetails = reviewDetails;
      this.customer = { id: customerId };
      this.travelDestination = { id: destinationId };
    }
}
