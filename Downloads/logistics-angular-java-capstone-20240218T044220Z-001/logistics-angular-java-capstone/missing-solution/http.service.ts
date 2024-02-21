import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment.development';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  public serverName=environment.apiUrl;
  constructor() {

   }
 
  getOrderStatus(cargoId:any):Observable<any> {
   
//complete this function
  }
  updateCargoStatus(newStatus:any,cargoId:any):Observable<any> {
  
   //complete this function
  }
  assignDriver(driverid: any, cargoId: any): Observable<any> {
   //complete this function
  }
  

  getAssignOrders(driverId:any):Observable<any> {
  //complete this function
  }
  getCargo():Observable<any> {
   //complete this function
  }

  getDrivers():Observable<any> {
   
  //complete this function
  }
  addCargo(details:any):Observable<any> {
  //complete this function
  }
  Login(details:any):Observable<any> {
    
  //complete this function
  }
  registerUser(details:any):Observable<any> {
   //complete this function
  }
 
  
  
}
