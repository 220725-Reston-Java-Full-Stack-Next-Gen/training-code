import { Component, OnInit, Inject } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { LoginTemplate } from 'src/app/models/login-template';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  //declare our component variable values
  public user = new LoginTemplate("", "");
  public isAuthenticated$: any;

  public showLogIn: boolean = true;
  public showLogOut: boolean = true;

  //inject this component with its dependencies
  constructor(@Inject(DOCUMENT) public document: Document, public userService: UserService, public router: Router) { }

  //This is a lifecycle hook
  //allow us to tap into the lifecycle of our components and trigger actions at specific points in the lifecycle
  //ngOnInit = called once at the start of the component's lifecycle, initialize the component after Angular first displays the HTML Template
  ngOnInit(): void {
    console.log('Checking current location:' + window.location.href)
    let target: HTMLElement | null = this.document.getElementById("login-container");
    console.log("Target: " + target!.id);
    if(window.location.href === "http://localhost:4200/login" || window.location.href === "http://dbz-api.s3-website-us-east-1.amazonaws.com/login"){
      console.log("on login page")
      target!.style.display = "initial";
    }else{
      console.log("On page: " + window.location.href.replace("http://localhost:4200/", "").replace("http://dbz-api.s3-website-us-east-1.amazonaws.com/", ""))
    }
  }

  //here is our other methods for the event binding on this page
  login(event: any){
    //1. print the incoming form data
    //the user data is coming from the html template through two-way binding - should be the real form data entered by end user
    console.log(`Form data is: ${this.user}`)

    //2. check the isAuthenticated variable by calling the service method to login
    this.isAuthenticated$ = this.userService.login(this.user.username, this.user.password);

    //3. print the authentication boolean
    console.log(`Authentication granted: ${this.isAuthenticated$}`);

    //4. check state of boolean
    if(this.isAuthenticated$ == true){
      //if true -> the user will then be redirected to the homepage
      console.log("redirecting to homepage...");
    }
    //if false -> do nothing
  }

  logout(){
    //1. print a quick debug message here
    console.log(`Logout event triggered. Current Location: ${this.document.location.origin}`);

    //2. call the logout() service method
    this.userService.logout();

    //3. print end-of-task message
    console.log('logout event complete')
  }

}
