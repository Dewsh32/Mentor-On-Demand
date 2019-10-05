import { Component } from '@angular/core';
import {Router} from  '@angular/router';

import {Mentor} from './msignup.model';
import {MsignupService} from './msignup.service';

@Component({
	selector: 'msignup',
	templateUrl: './msignup.component.html',
	styleUrls: ['./msignup.component.css']


})
export class MsignupComponent {
	active=true;
	date= new Date();

	newMentor: Mentor=new Mentor();

	constructor(private router: Router, private msignupService: MsignupService)
	{

	}

	createMentor(): void{
		this.newMentor.resetPasswordDate=this.date;
		this.newMentor.active=this.active;
		this.newMentor.regCode=this.newMentor.firstName+this.newMentor.contactNumber;
		this.newMentor.role="mentor";
		this.msignupService.createMentor(this.newMentor)
		.subscribe(data=>{
			alert("Signup successfull");
		});
	};
	
}