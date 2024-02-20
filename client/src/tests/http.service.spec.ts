import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormBuilder } from '@angular/forms';
import { LoginComponent } from '../app/login/login.component';
import { AuthService } from '../services/auth.service';
import { HttpService } from '../services/http.service';

describe('HttpService', () => {
  let service: HttpService;
  let httpMock: HttpTestingController;
  let componentLogin: LoginComponent;
  let fixtureLogin: ComponentFixture<LoginComponent>;
  let formBuilderLogin: FormBuilder;
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule,],
      providers: [
        HttpService,
        { provide: AuthService, useValue: { getToken: () => 'mockToken' } } // Mock implementation of AuthService
      ]// Remove HttpClient from providers
    });
    service = TestBed.inject(HttpService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should get State Name', () => {
    const driverId = 123;
    const cargoId = 456;
    const mockResponse = { success: true };
  
    service. getStatename().subscribe(response => {
      expect(response).toEqual(mockResponse);
    });
  
    const req = httpMock.expectOne(`${service.serverName}/api/business/assign-cargo?cargoId=${cargoId}&driverId=${driverId}`);
    expect(req.request.method).toBe('POST');
    expect(req.request.headers.get('Content-Type')).toBe('application/json');
    expect(req.request.headers.get('Authorization')).toBe('Bearer mockToken');
    req.flush(mockResponse);
  });
  
  it('should fetch destination data', () => {
    const mockResponse = [{ id: 1, name: 'driver1',email:'driver@gmail.com' }, { id: 2, name: 'driver 2',email:'driver2@gmail.com' }];

    service.getDestinationData().subscribe(response => {
      expect(response).toEqual(mockResponse);
    });

    const req = httpMock.expectOne(`${service.serverName}/api/business/drivers`);
    expect(req.request.method).toBe('GET');
    expect(req.request.headers.get('Content-Type')).toBe('application/json');
    expect(req.request.headers.get('Authorization')).toBe('Bearer mockToken');
    req.flush(mockResponse);
  });

  it('should add review', () => {
    const mockDetails = { content: 'Cargo Content', size: 'Medium', status: 'Pending' };
    const mockResponse = { id: 1, content: 'Cargo Content', size: 'Medium', status: 'Pending' };

    service.addReview(mockDetails).subscribe(response => {
      expect(response).toEqual(mockResponse);
    });

    const req = httpMock.expectOne(`${service.serverName}/api/business/cargo`);
    expect(req.request.method).toBe('POST');
    expect(req.request.headers.get('Content-Type')).toBe('application/json');
    expect(req.request.headers.get('Authorization')).toBe('Bearer mockToken');
    expect(req.request.body).toEqual(mockDetails);
    req.flush(mockResponse);
  });
  it('should login', () => {
    const mockDetails = { username: 'testuser', password: 'testpassword' };
    const mockResponse = { token: 'mockToken' };

    service.Login(mockDetails).subscribe(response => {
      expect(response).toEqual(mockResponse);
    });

    const req = httpMock.expectOne(`${service.serverName}/api/login`);
    expect(req.request.method).toBe('POST');
    expect(req.request.headers.get('Content-Type')).toBe('application/json');
    expect(req.request.body).toEqual(mockDetails);
    req.flush(mockResponse);
  });
  it('should register user', () => {
    const mockDetails = { username: 'testuser', email: 'test@example.com', password: 'testpassword' };
    const mockResponse = { message: 'User registered successfully' };

    service.registerUser(mockDetails).subscribe(response => {
      expect(response).toEqual(mockResponse);
    });

    const req = httpMock.expectOne(`${service.serverName}/api/register`);
    expect(req.request.method).toBe('POST');
    expect(req.request.headers.get('Content-Type')).toBe('application/json');
    expect(req.request.body).toEqual(mockDetails);
    req.flush(mockResponse);
  });

});
