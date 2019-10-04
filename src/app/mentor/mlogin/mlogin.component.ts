import { Component } from '@angular/core';

import {Mentor} from './mlogin.model';
import {Router} from '@angular/router';
import {MloginService} from './mlogin.service';

@Component({
	selector: 'mlogin',
	templateUrl: './mlogin.component.html',
	styleUrls: ['./mlogin.component.css']

})
export class MloginComponent {
	mentors: Mentor[];
	mentor: Mentor=new Mentor();

	constructor(private router: Router, private mloginService: MloginService)
	{

	}


	authenticate(username,password): void{


		this.mloginService.authenticate(username,password).subscribe(data=> {
			if(data==null)
			{
				alert("incorrect credentials");
			}
			else if(data!=null)
			{
				sessionStorage.setItem('role',data.role)
				sessionStorage.setItem('id',data.id)
				sessionStorage.setItem('username',data.userName)
				sessionStorage.removeItem('showId')
				this.router.navigate(['mmenu']);
			}
		})


	};
}