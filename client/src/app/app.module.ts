import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegistrationComponent } from './registration/registration.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { HttpService } from '../services/http.service';
import { DashbaordComponent } from './dashbaord/dashbaord.component';
import { AddReviewComponent } from './add-review/add-review.component';
import { AddDestinationComponent } from './add-destination/add-destination.component';
import { ViewDestinationComponent } from './view-destination/view-destination.component';
import { ViewReviewComponent } from './view-review/view-review.component';
import { EditReviewComponent } from './edit-review/edit-review.component';
import { ProfileManagementComponent } from './profile-management/profile-management.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    AddReviewComponent,DashbaordComponent, AddDestinationComponent, ViewDestinationComponent, ViewReviewComponent, EditReviewComponent, ProfileManagementComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule 
  ],
  providers: [HttpService,HttpClientModule ],
  bootstrap: [AppComponent]
})
export class AppModule { }
