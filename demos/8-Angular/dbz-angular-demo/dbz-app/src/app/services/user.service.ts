import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { User } from '../models/user';
import { HttpClient } from '@angular/common/http';
import { ClientMessage } from '../models/client-message';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  /*
    Q: What is a service and what makes it different from a component?

    - reusable pieces of code that can be used to share data between other components
    - You would use services to establish a communication of data between components
    - The components would then subscribe to that service to tap into that data and retrieve/send what it needs

    - Azhya does NOT want you guys to relate services with HTTPClient! Those are two different things:
    - HTTPClient is a built-in Angular class that uses RxJS observables to make HTTP requests to external servers
    - Observables are like Promises!
  */

  //1. declare your variables
  isAuthenicated: boolean = false;
  user$!: User; //because of this value possibly being null during runtime, I'm flagging this variable with the definite assertion syntax($ and/or !)
  url: string = environment.APP_URL;

  //2. inject our service with needed dependencies via constructor injection
  constructor(private http: HttpClient, private router: Router) { }

  //3. define and implement our methods that we need
  //a. authenication methods
  getAuthStatus(): boolean{
    if(this.isAuthenicated){
      console.log('Access granted for this user');
    }else{
      console.log('Access denied. Please log in.');
    }

    return this.isAuthenicated;
  }

  register(user: User): void{
    //a. set up my JSON data that is coming from the form
    let body = {
      username: user.username,
      password: user.password,
      firstName: user.firstname,
      lastName: user.lastname,
      email: user.email
    };

    //b. make a POST request call to our server
    this.http.post<ClientMessage>(`${this.url}users/register`, JSON.stringify(body))
    .subscribe(data => {
      console.log(data);
    })
  }
}
