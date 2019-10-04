import { Component } from '@angular/core';


import{User} from './ulogin.model';
import { Router } from '@angular/router';
import { UloginService } from './ulogin.service';

@Component({
	selector: 'ulogin',
	templateUrl: './ulogin.component.html',
	styleUrls: ['./ulogin.component.css']

})
export class UloginComponent {

	users: User[];
	user: User=new User();
	constructor(private router: Router, private uloginService: UloginService)
	{

	}

	

	authenticate(username,password): void{

		 //utem=this.uloginService.authenticate(username,password);
		//alert(utemp);
		this.uloginService.authenticate(username,password).subscribe( data => {
			if(data==null)
			{
				alert("incorrect credentials");
			}
			else if(data!=null)
			{
				sessionStorage.setItem('role', data.role)
				sessionStorage.setItem('username', data.userName)
				sessionStorage.setItem('id',data.id)
				sessionStorage.setItem('showId',"true")

				this.router.navigate(['umenu']);
			}
		  })
		
	};


	
	
}