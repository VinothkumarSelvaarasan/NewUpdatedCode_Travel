import { Component, OnInit } from '@angular/core';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { AuthService } from '../../services/auth.service';
import { Review } from '../model/review';
@Component({
  selector: 'app-view-review',
  templateUrl: './view-review.component.html',
  styleUrls: ['./view-review.component.scss']
})
export class ViewReviewComponent implements OnInit {

  destinationData:any={}
  showError:any;
  errorMessage: any;
  review: Review[]=[];

  constructor(public router:Router, public httpService:HttpService, private formBuilder: FormBuilder, private authService:AuthService) 
  {

  }
  ngOnInit(): void {
    this.search();
  }
  search()
  {
    debugger;
      this.destinationData={};
      this.httpService.getReviewData().subscribe((data: any) => {
        this.review=data;
        console.log(data.reviewDetails);
      }, error => {
        // Handle error
        this.showError = true;
        this.errorMessage = "An error occurred while searching in. Please try again later or no record found";
        console.error('Login error:', error);
      });;
    }
}
