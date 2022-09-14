import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  //1. declare variables
  user: User = new User(0, "", "", "", "", "");
  isRegistered: boolean = false;

  //2. inject in our dependencies
  constructor(private router: Router, private service: UserService) { }

  ngOnInit(): void {

  }

  //3. a method that will trigger with a click event for our form
  register(event: any){
    //here Angular forms will actively retrieve the form data based on our two-way binding back in our HTML template
    console.log("Form data: " + JSON.stringify(this.user));

    //check if I have all of the form data
    
    if(
      this.user.username !== "" &&
      this.user.password !== "" &&
      this.user.firstname !== "" &&
      this.user.lastname !== "" &&
      this.user.email !== "" 
      ){
        //yes - call our service method here
        this.service.register(this.user);
        
        //automatically send the user back to main screen
        this.router.navigateByUrl("/login");
      }else{
        //no - throw error
        throw new Error("Empty fields in form!");
      }
    }
  }
