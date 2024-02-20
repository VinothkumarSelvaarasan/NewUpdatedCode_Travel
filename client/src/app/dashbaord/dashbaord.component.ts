import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { AuthService } from '../../services/auth.service';
@Component({
  selector: 'app-dashbaord',
  templateUrl: './dashbaord.component.html',
  styleUrls: ['./dashbaord.component.scss']
})
export class DashbaordComponent implements OnInit {
  statenam:any={}
  showError:any;
  errorMessage: any;
  stateIdMd:any;
  roleName: string | null;
  constructor(public router:Router, public httpService:HttpService, private formBuilder: FormBuilder, private authService:AuthService) 
  {
    console.log("Constructor");
    this.roleName=authService.getRole;
  }
  ngOnInit(): void {
    console.log("ngOnInit");
    this.dashboardView();
  }

  dashboardView()
  {
    console.log(this.stateIdMd);
    debugger;
   
      console.log("stateMd Call");
      this.statenam={};
      this.httpService.getStatename().subscribe((data: any) => {
        this.statenam=data;
        console.log(this.statenam);
      }, error => {
        // Handle error
        this.showError = true;
        this.errorMessage = "An error occurred while searching in. Please try again later or no record found";
        console.error('Login error:', error);
      });;
    }
     
    
  }

