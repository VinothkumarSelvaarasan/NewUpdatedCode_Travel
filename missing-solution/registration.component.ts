import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../../services/http.service';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html'
 
})
export class RegistrationComponent {

  itemForm: FormGroup;
  formModel:any={userType:null,email:'',password:'',username:''};
  showMessage:boolean=false;

  responseMessage: any;
  constructor(public router:Router, private bookService:HttpService, private formBuilder: FormBuilder) { 
    //compelete this 
      }

  ngOnInit(): void {
  }
  onRegister()
  {
    if(this.itemForm.valid)
    {
      this.showMessage=false;
      this.bookService.registerUser(this.itemForm.value).subscribe(data=>{    
        debugger;
        this.showMessage=true;
        this.responseMessage='Welcome '+data.name+" you are successfully registered";
        this.itemForm.reset();
        
      },error=>{ })
    }
    else{
      this.itemForm.markAllAsTouched();
    }
  }


}
