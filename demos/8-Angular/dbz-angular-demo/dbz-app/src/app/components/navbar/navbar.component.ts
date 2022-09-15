import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MdbModalRef, MdbModalService } from 'mdb-angular-ui-kit/modal';
import { UserService } from 'src/app/services/user.service';
import { CreateComponent } from '../blogs/create/create.component';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  //1. declare our local variables
  isCollapsed = true;
  currentUserName: string;
  modalRef: MdbModalRef<CreateComponent> | null = null;

  //2. inject this component of its needed dependencies
  constructor(public auth: UserService, private modalService: MdbModalService, private router: Router) { }

  //3. initialize the value of currentUserName when this component is initialized
  ngOnInit(): void {
    //1. check if there is a localStorage of the username available
    //currentUser was saved when our user logged in
    if(localStorage.getItem("current-user")){
      // if yes -> assign the local currentUserName to that stored value
      let value = JSON.parse(localStorage.getItem("current-user"));
      console.log(value);
      this.currentUserName = value.username;
    }else{
      // if no -> set the currentUserName to ""
      this.currentUserName = "";
    }
  }

  //4. establish my other operations that I want this component class to do with methods below:
  //this method is used to close the menu bar when button is clicked
  public closeMenuEvent(){
    console.log("closing side menu bar...");
    this.isCollapsed = !this.isCollapsed;
  }

  //this method will be working with Angular Materials to open a modal for when users want to create a new blog post
  public openModal(){
    this.modalRef = this.modalService.open(CreateComponent);
  }

  //this method will log out the user when clicked
  public logout(event: any){
    localStorage.clear();
    this.router.navigateByUrl("/login");
  }

}
