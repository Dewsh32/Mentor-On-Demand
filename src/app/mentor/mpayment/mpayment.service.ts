import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Mentor } from './mpayment.model';
import {Payment} from './mpayment.model';



const httpOptions = {
headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable()
export class MpaymentService{
  id=sessionStorage.getItem("id")

  constructor(private http:HttpClient){}

  private MUrl = 'http://localhost:8885/mentor/';
  private PayUrl= 'http://localhost:8885/payment/';
  private TUrl='http://localhost:8885/training/';

  public getMentor()
  {
    return this.http.get<Mentor>(this.MUrl+this.id);
  }
  public getPayment()
  {
    return this.http.get<Payment[]>(this.PayUrl+"/findbyuser/"+this.id);
  }

 
  
  public Withdraw(payid,amount)
  {
    return this.http.get<Payment>(this.PayUrl+"withdraw/"+payid+"/"+amount)
  }


}