import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { AuthService } from '../../services/auth.service';
import { ReviewData } from '../model/review-data';


@Component({
  selector: 'app-addreview',
  templateUrl: './add-review.component.html'
 
})
export class AddReviewComponent {
  itemForm: FormGroup;
  formModel:any={status:null};
  showError:boolean=false;
  errorMessage:any;
  cargList:any=[];
  assignModel: any={};
  driverList:any=[]
  userId: number=0;
  responseMessage: any=[];
  //iduser: number;
  destinationData:any=[];
  showMessage:boolean=false;
  idNum: any | null;
  locationData:any=[];

  constructor(public router:Router, public httpService:HttpService, private formBuilder: FormBuilder, private authService:AuthService) 
    {
   
      this.idNum=authService.getId;
      this.itemForm = this.formBuilder.group({
        statenam: [this.formModel.statenam,[ Validators.required]],
        locationName: [this.formModel.locationName,[ Validators.required]],
        reviewDetails: [this.formModel.reviewDetails,[ Validators.required]]
       
    });
  }
  ngOnInit(): void {
  // console.log(this.authService.getId());
    this.search();
   // alert(this.idNum);

  }
  
  
  onSubmit()
  {
  
    if(this.itemForm.valid)
    {
      if (this.itemForm.valid) {

        const newReview = new ReviewData(this.itemForm.value.reviewDetails, this.idNum, this.itemForm.value.statenam);
        this.showMessage=false;
        this.httpService.addReview(newReview).subscribe((data: any) => {
          this.itemForm.reset();
          this.showMessage=true;
          this.responseMessage="Review Added Successfully";
          this
          
        }, error => {
          // Handle error
          this.showError = true;
          this.errorMessage = "An error occurred while logging in. Please try again later.";
          console.error('Login error:', error);
        });
      } else {
        this.itemForm.markAllAsTouched();
      }
    }
    else{
      this.itemForm.markAllAsTouched();
    }
  }

  search()
  {
    debugger;
  
      this.httpService.getDestinationData().subscribe((data: any) => {
        this.destinationData=data;
        console.log(this.destinationData.locationName);
       // this.locationData=data
        debugger;
      
     
        this.itemForm.reset();
      }, error => {
        // Handle error
        this.showError = false;
        this.errorMessage = "An error occurred while searching in. Please try again later or no record found";
        console.error('Login error:', error);
      });;
    }
  
}
