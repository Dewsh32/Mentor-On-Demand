import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from './ulogin.model';

const httpOptions = {
headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable()
export class UloginService{

  constructor(private http:HttpClient){}

  private UserUrl = 'http://localhost:8885/user/';


  public authenticate(username,password)
  {
    return this.http.get<User>(this.UserUrl+username+"/"+password);
  }



}