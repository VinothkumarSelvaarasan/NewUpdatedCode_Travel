import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../../services/http.service';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-assgin-cargo',
  templateUrl: './assgin-cargo.component.html',
  styleUrls: ['./assgin-cargo.component.scss']
})
export class AssginCargoComponent {
  

  showError:boolean=false;
  errorMessage:any;
  cargList:any=[];
  statusModel: any={};
  showMessage: any;
  responseMessage: any;

  constructor(public router:Router, public httpService:HttpService, private formBuilder: FormBuilder, private authService:AuthService) 
  {
  }
  ngOnInit(): void {

  }
  getAssginCargo() {
  //complete this function
  }
  addStatus(value:any)
  {
  //complete this function
  }
  assignDriver()
  {//complete this function
  }


  
}
