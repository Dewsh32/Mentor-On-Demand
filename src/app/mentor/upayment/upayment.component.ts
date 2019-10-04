import { Component,OnInit } from '@angular/core';


import {User} from './upayment.model';
import {Router} from '@angular/router';
import {UpaymentService} from './upayment.service';
import {Payment} from './upayment.model';
import {Training} from './upayment.model';


@Component({
	selector: 'upayment',
	templateUrl: './upayment.component.html'

})
export class UpaymentComponent implements OnInit {

	user=sessionStorage.getItem("username")
	users: User[];
	user1: User=new User();
	payments: Payment[];
	training: Training=new Training();
	showId=false;
	Payid;
	amt;
	
	constructor(private router: Router,private upaymentService: UpaymentService)
	{
		
	}

	ngOnInit(){
		this.upaymentService.getUser()
		.subscribe(data=>{
			this.user1=data;
		});

		this.upaymentService.getPayment()
		.subscribe(data1=>{
			this.payments=data1;
		});


	}


	getTrainings(Pid,amount,payid)
	{
		this.Payid=payid;
		this.amt=amount;
		
		this.upaymentService.getTrainings(payid)
		.subscribe(data=>{
			this.training=data;
		});
		this.showId=!this.showId;
		
	}

	Payfees(amount){

		if(this.amt==0)
		{
			this.upaymentService.Payfees(this.Payid,amount)
		.subscribe(data=>{
			alert("Fees Successfully Paid!");
		});

		}
		else{
			alert("already paid");
		}


		

	}
	
}