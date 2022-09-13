import { Injectable } from '@angular/core';

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

  constructor() { }
}
