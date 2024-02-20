import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormBuilder, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { AuthService } from '../services/auth.service';
import { HttpService } from '../services/http.service';
import { AddDestinationComponent } from '../app/add-destination/add-destination.component';

;

describe('AddDestinationComponent', () => {
  let component: AddDestinationComponent;
  let fixture: ComponentFixture<AddDestinationComponent>;
  let formBuilder: FormBuilder;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AddDestinationComponent],
      imports: [ReactiveFormsModule,FormsModule,HttpClientTestingModule,RouterTestingModule],
      providers: [HttpService, AuthService] 
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddDestinationComponent);
    component = fixture.componentInstance;
    formBuilder = TestBed.inject(FormBuilder);

    // Create a FormGroup with the form controls defined in your component
    component.itemForm = formBuilder.group({
      content: ['', Validators.required],
      size: ['', Validators.required],
      status: ['', Validators.required]
    });

    fixture.detectChanges();
  });

  it('should have invalid form if any field is empty', () => {
    const form = component.itemForm;
    expect(form.valid).toBeFalsy();

    const contentControl = form.controls['content'];
    expect(contentControl.valid).toBeFalsy();

    const sizeControl = form.controls['size'];
    expect(sizeControl.valid).toBeFalsy();

    const statusControl = form.controls['status'];
    expect(statusControl.valid).toBeFalsy();
  });

  it('should have valid form if all fields are filled', () => {
    const form = component.itemForm;
    const contentControl = form.controls['content'];
    const sizeControl = form.controls['size'];
    const statusControl = form.controls['status'];

    // Set valid values
    contentControl.setValue('Cargo content');
    sizeControl.setValue('Large');
    statusControl.setValue('Pending');

    expect(form.valid).toBeTruthy();
  });
});
