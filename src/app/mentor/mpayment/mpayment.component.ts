import { Component,OnInit } from '@angular/core';



import { Mentor } from './mpayment.model';
import {Payment} from './mpayment.model';
import {Training} from './mpayment.model';
import {Router} from '@angular/router';
import {MpaymentService} from './mpayment.service';


@Component({
	selector: 'mpayment',
	templateUrl: './mpayment.component.html'

})
export class MpaymentComponent implements OnInit {

	user=sessionStorage.getItem("username");
	mentor: Mentor=new Mentor();
	payments: Payment[];
	showId=false;
	withdrawAmount;
	amount;
	pid;

	constructor(private router: Router,private mpaymentService: MpaymentService)
	{

	}

	ngOnInit(){
		this.mpaymentService.getMentor()
		.subscribe(data=>{
			this.mentor=data;
		});

		this.mpaymentService.getPayment()
		.subscribe(data1=>{
			this.payments=data1;
		});
	}

	toggle(amount,pid){
		this.amount=amount;
		this.pid=pid;
		this.showId=!this.showId;
		
	}

	Withdraw(amt){
		if(amt>this.amount)
		{
			alert("insufficient funds");
		}
		else
		{
			this.mpaymentService.Withdraw(this.pid,amt)
			.subscribe(data=>{
			alert("Withdraw Successfull");
			});
		
		}


	}

	


		

	
}