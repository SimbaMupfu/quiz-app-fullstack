import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

const BASIC_URL = "http://localhost:8080/api/";

const SIGNUP_ENDPOINT = "auth/sign-up"
const LOGIN_ENDPOINT = "auth/login"

@Injectable({
  providedIn: 'root',
})
export class Auth {
  constructor(private http: HttpClient){}

  register(data): Observable<any>{
    return this.http.post(BASIC_URL + SIGNUP_ENDPOINT, data);
  }

  login(loginRequest: any): Observable<any>{
    return this.http.post(BASIC_URL + LOGIN_ENDPOINT, loginRequest);
  }
}
