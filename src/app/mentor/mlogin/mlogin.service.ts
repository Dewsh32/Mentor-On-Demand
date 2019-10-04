import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Mentor } from './mlogin.model';

const httpOptions = {
headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable()
export class MloginService{

  constructor(private http:HttpClient){}

  private MentorUrl = 'http://localhost:8885/mentor/';


  public authenticate(username,password)
  {
    return this.http.get<Mentor>(this.MentorUrl+username+"/"+password);
  }



}