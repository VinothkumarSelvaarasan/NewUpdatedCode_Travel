import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { AuthService } from '../../services/auth.service';


@Component({
  selector: 'app-addcargo',
  templateUrl: './addcargo.component.html',
  styleUrls: ['./addcargo.component.scss']
})
export class AddcargoComponent implements OnInit {
  itemForm: FormGroup;
  formModel:any={status:null,content:'',size:''};
  showError:boolean=false;
  errorMessage:any;
  cargList:any=[];
  assignModel: any={};
  driverList:any=[]
  showMessage: any;
  responseMessage: any;
  constructor(public router:Router, public httpService:HttpService, private formBuilder: FormBuilder, private authService:AuthService) 
    {
      // this.itemForm = //complete this 
  }
  ngOnInit(): void {
 
  }
  getCargo() {
 //complete this function
  }
  getDrivers() {
  //complete this function
  }
 
  onSubmit()
  {
    //complete this function
  }
  addDriver(value:any)
  {
   //complete this function
  }
  assignDriver()
  {
   //complete this function
  }
  
}
