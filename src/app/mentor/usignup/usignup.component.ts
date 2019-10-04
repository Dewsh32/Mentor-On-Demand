import { Component } from '@angular/core';
import {Router} from '@angular/router';

import {User} from './usignup.model';
import {UsignupService} from './usignup.service';


@Component({
	selector: 'usignup',
	templateUrl: './usignup.component.html',
	styleUrls: ['./usignup.component.css']

})
export class UsignupComponent {

	active=true;
	date= new Date();
	user=Math.random();
	newUser: User= new User();

	constructor(private router: Router, private usignupService: UsignupService){

	}

	createUser(): void {
		this.newUser.resetPasswordDate=this.date;
		this.newUser.active=this.active;
		this.newUser.regCode=this.newUser.firstName+this.newUser.contactNumber;
		this.usignupService.createUser(this.newUser)
		.subscribe(data=>{
			alert("Signup successfull");
		});
	};
	
}